package com.baidu.zeus;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.util.Log;
import com.baidu.android.common.util.HanziToPinyin;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class RequestQueue implements RequestFeeder {
    private static final int CONNECTION_COUNT = 4;
    private static final Uri PREFERRED_APN_URI = Uri.parse("content://telephony/carriers/preferapn");
    private static final String PROXY_HOST_CMWAP = "10.0.0.172";
    private static final String PROXY_HOST_CTWAP = "10.0.0.200";
    private final String LOGTAG;
    private final ActivePool mActivePool;
    private final ConnectivityManager mConnectivityManager;
    private final Context mContext;
    private final LinkedHashMap mPending;
    private BroadcastReceiver mProxyChangeReceiver;
    private HttpHost mProxyHost;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface ConnectionManager {
        Connection getConnection(Context context, HttpHost httpHost);

        HttpHost getProxyHost();

        boolean recycleConnection(Connection connection);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class ActivePool implements ConnectionManager {
        private int mConnectionCount;
        IdleCache mIdleCache = new IdleCache();
        ConnectionThread[] mThreads;
        private int mTotalConnection;
        private int mTotalRequest;

        static /* synthetic */ int access$408(ActivePool activePool) {
            int i = activePool.mTotalRequest;
            activePool.mTotalRequest = i + 1;
            return i;
        }

        ActivePool(int i) {
            this.mConnectionCount = i;
            this.mThreads = new ConnectionThread[this.mConnectionCount];
            for (int i2 = 0; i2 < this.mConnectionCount; i2++) {
                this.mThreads[i2] = new ConnectionThread(RequestQueue.this.mContext, i2, this, RequestQueue.this);
            }
        }

        void startup() {
            for (int i = 0; i < this.mConnectionCount; i++) {
                this.mThreads[i].start();
            }
        }

        void shutdown() {
            for (int i = 0; i < this.mConnectionCount; i++) {
                this.mThreads[i].requestStop();
            }
        }

        void startConnectionThread() {
            synchronized (RequestQueue.this) {
                RequestQueue.this.notify();
            }
        }

        public void startTiming() {
            for (int i = 0; i < this.mConnectionCount; i++) {
                ConnectionThread connectionThread = this.mThreads[i];
                connectionThread.mCurrentThreadTime = -1L;
                connectionThread.mTotalThreadTime = 0L;
            }
            this.mTotalRequest = 0;
            this.mTotalConnection = 0;
        }

        public void stopTiming() {
            int i = 0;
            for (int i2 = 0; i2 < this.mConnectionCount; i2++) {
                ConnectionThread connectionThread = this.mThreads[i2];
                if (connectionThread.mCurrentThreadTime != -1) {
                    i = (int) (i + connectionThread.mTotalThreadTime);
                }
                connectionThread.mCurrentThreadTime = 0L;
            }
            Log.d("Http", "Http thread used " + i + " ms  for " + this.mTotalRequest + " requests and " + this.mTotalConnection + " new connections");
        }

        void logState() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < this.mConnectionCount; i++) {
                sb.append(this.mThreads[i] + "\n");
            }
            HttpLog.v(sb.toString());
        }

        @Override // com.baidu.zeus.RequestQueue.ConnectionManager
        public HttpHost getProxyHost() {
            return RequestQueue.this.mProxyHost;
        }

        void disablePersistence() {
            for (int i = 0; i < this.mConnectionCount; i++) {
                Connection connection = this.mThreads[i].mConnection;
                if (connection != null) {
                    connection.setCanPersist(false);
                }
            }
            this.mIdleCache.clear();
        }

        ConnectionThread getThread(HttpHost httpHost) {
            synchronized (RequestQueue.this) {
                for (int i = 0; i < this.mThreads.length; i++) {
                    ConnectionThread connectionThread = this.mThreads[i];
                    Connection connection = connectionThread.mConnection;
                    if (connection != null && connection.mHost.equals(httpHost)) {
                        return connectionThread;
                    }
                }
                return null;
            }
        }

        @Override // com.baidu.zeus.RequestQueue.ConnectionManager
        public Connection getConnection(Context context, HttpHost httpHost) {
            HttpHost determineHost = RequestQueue.this.determineHost(httpHost);
            Connection connection = this.mIdleCache.getConnection(determineHost);
            if (connection == null) {
                this.mTotalConnection++;
                return Connection.getConnection(RequestQueue.this.mContext, determineHost, RequestQueue.this.mProxyHost, RequestQueue.this);
            }
            return connection;
        }

        @Override // com.baidu.zeus.RequestQueue.ConnectionManager
        public boolean recycleConnection(Connection connection) {
            return this.mIdleCache.cacheConnection(connection.getHost(), connection);
        }
    }

    public RequestQueue(Context context) {
        this(context, 4);
    }

    public RequestQueue(Context context, int i) {
        this.LOGTAG = "RequestQueue";
        this.mProxyHost = null;
        this.mContext = context;
        this.mPending = new LinkedHashMap(32);
        this.mActivePool = new ActivePool(i);
        this.mActivePool.startup();
        this.mConnectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
    }

    public synchronized void enablePlatformNotifications() {
        if (this.mProxyChangeReceiver == null) {
            this.mProxyChangeReceiver = new BroadcastReceiver() { // from class: com.baidu.zeus.RequestQueue.1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    RequestQueue.this.setProxyConfig();
                }
            };
            this.mContext.registerReceiver(this.mProxyChangeReceiver, new IntentFilter("android.intent.action.PROXY_CHANGE"));
        }
        setProxyConfig();
    }

    public synchronized void disablePlatformNotifications() {
        if (this.mProxyChangeReceiver != null) {
            this.mContext.unregisterReceiver(this.mProxyChangeReceiver);
            this.mProxyChangeReceiver = null;
        }
    }

    private synchronized void checkApnType(NetworkInfo networkInfo) {
        String str;
        int i;
        String str2;
        boolean z = true;
        synchronized (this) {
            if (networkInfo == null) {
                this.mProxyHost = null;
            } else {
                int i2 = -1;
                String lowerCase = networkInfo.getExtraInfo() != null ? networkInfo.getExtraInfo().toLowerCase() : null;
                if (lowerCase == null) {
                    this.mProxyHost = null;
                } else {
                    if (lowerCase.startsWith("cmwap") || lowerCase.startsWith("uniwap") || lowerCase.startsWith("3gwap")) {
                        str = "10.0.0.172";
                        i2 = 80;
                    } else if (lowerCase.startsWith("ctwap")) {
                        str = PROXY_HOST_CTWAP;
                        i2 = 80;
                    } else if (lowerCase.startsWith("cmnet") || lowerCase.startsWith("uninet") || lowerCase.startsWith("ctnet") || lowerCase.startsWith("3gnet")) {
                        str = null;
                    } else {
                        z = false;
                        str = null;
                    }
                    Cursor query = (z || this.mContext == null) ? null : this.mContext.getContentResolver().query(PREFERRED_APN_URI, new String[]{"_id", "apn", "proxy", "user"}, null, null, null);
                    if (query != null) {
                        query.moveToFirst();
                        query.getCount();
                        if (!query.isAfterLast()) {
                            String string = query.getString(1);
                            String string2 = query.getString(2);
                            String string3 = query.getString(3);
                            if (string2 != null && string2.length() > 0) {
                                if ("10.0.0.172".equals(string2.trim())) {
                                    i = 80;
                                    str2 = "10.0.0.172";
                                } else if (PROXY_HOST_CTWAP.equals(string2.trim())) {
                                    i = 80;
                                    str2 = PROXY_HOST_CTWAP;
                                }
                                query.close();
                            } else if (string != null && string.length() > 0) {
                                String upperCase = string.toUpperCase();
                                if (upperCase.equals("CMWAP") || upperCase.equals("UNIWAP") || upperCase.equals("3GWAP")) {
                                    i = 80;
                                    str2 = "10.0.0.172";
                                } else if (upperCase.equals("CTWAP")) {
                                    i = 80;
                                    str2 = PROXY_HOST_CTWAP;
                                } else if (string3 != null && string3.toUpperCase().startsWith("CMWAP")) {
                                    i = 80;
                                    str2 = "10.0.0.172";
                                }
                                query.close();
                            }
                        }
                        i = i2;
                        str2 = str;
                        query.close();
                    } else {
                        i = i2;
                        str2 = str;
                    }
                    if (str2 != null && i > 0) {
                        this.mActivePool.disablePersistence();
                        this.mProxyHost = new HttpHost(str2, i, "http");
                    } else {
                        this.mProxyHost = null;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void setProxyConfig() {
        NetworkInfo activeNetworkInfo = this.mConnectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.getType() == 1) {
            this.mProxyHost = null;
        } else {
            checkApnType(activeNetworkInfo);
        }
    }

    public HttpHost getProxyHost() {
        return this.mProxyHost;
    }

    public RequestHandle queueRequest(String str, String str2, Map map, EventHandler eventHandler, InputStream inputStream, int i) {
        return queueRequest(str, new WebAddress(str), str2, map, eventHandler, inputStream, i);
    }

    public RequestHandle queueRequest(String str, WebAddress webAddress, String str2, Map map, EventHandler eventHandler, InputStream inputStream, int i) {
        Request request = new Request(str2, new HttpHost(webAddress.mHost, webAddress.mPort, webAddress.mScheme), this.mProxyHost, webAddress.mPath, inputStream, i, eventHandler == null ? new LoggingEventHandler() : eventHandler, map);
        queueRequest(request, false);
        ActivePool.access$408(this.mActivePool);
        this.mActivePool.startConnectionThread();
        return new RequestHandle(this, str, webAddress, str2, map, inputStream, i, request);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class SyncFeeder implements RequestFeeder {
        private Request mRequest;

        SyncFeeder() {
        }

        @Override // com.baidu.zeus.RequestFeeder
        public Request getRequest() {
            Request request = this.mRequest;
            this.mRequest = null;
            return request;
        }

        @Override // com.baidu.zeus.RequestFeeder
        public Request getRequest(HttpHost httpHost) {
            return getRequest();
        }

        @Override // com.baidu.zeus.RequestFeeder
        public boolean haveRequest(HttpHost httpHost) {
            return this.mRequest != null;
        }

        @Override // com.baidu.zeus.RequestFeeder
        public void requeueRequest(Request request) {
            this.mRequest = request;
        }
    }

    public RequestHandle queueSynchronousRequest(String str, WebAddress webAddress, String str2, Map map, EventHandler eventHandler, InputStream inputStream, int i) {
        HttpHost httpHost = new HttpHost(webAddress.mHost, webAddress.mPort, webAddress.mScheme);
        return new RequestHandle(this, str, webAddress, str2, map, inputStream, i, new Request(str2, httpHost, this.mProxyHost, webAddress.mPath, inputStream, i, eventHandler, map), Connection.getConnection(this.mContext, determineHost(httpHost), this.mProxyHost, new SyncFeeder()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HttpHost determineHost(HttpHost httpHost) {
        return (this.mProxyHost == null || "https".equals(httpHost.getSchemeName())) ? httpHost : this.mProxyHost;
    }

    synchronized boolean requestsPending() {
        return !this.mPending.isEmpty();
    }

    synchronized void dump() {
        HttpLog.v("dump()");
        StringBuilder sb = new StringBuilder();
        if (!this.mPending.isEmpty()) {
            Iterator it = this.mPending.entrySet().iterator();
            int i = 0;
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                int i2 = i + 1;
                StringBuilder sb2 = new StringBuilder("p" + i + HanziToPinyin.Token.SEPARATOR + ((HttpHost) entry.getKey()).getHostName() + HanziToPinyin.Token.SEPARATOR);
                ((LinkedList) entry.getValue()).listIterator(0);
                while (it.hasNext()) {
                    sb2.append(((Request) it.next()) + HanziToPinyin.Token.SEPARATOR);
                }
                sb.append((CharSequence) sb2);
                sb.append("\n");
                i = i2;
            }
        }
        HttpLog.v(sb.toString());
    }

    @Override // com.baidu.zeus.RequestFeeder
    public synchronized Request getRequest() {
        return this.mPending.isEmpty() ? null : removeFirst(this.mPending);
    }

    @Override // com.baidu.zeus.RequestFeeder
    public synchronized Request getRequest(HttpHost httpHost) {
        Request request;
        request = null;
        if (this.mPending.containsKey(httpHost)) {
            LinkedList linkedList = (LinkedList) this.mPending.get(httpHost);
            request = (Request) linkedList.removeFirst();
            if (linkedList.isEmpty()) {
                this.mPending.remove(httpHost);
            }
        }
        return request;
    }

    @Override // com.baidu.zeus.RequestFeeder
    public synchronized boolean haveRequest(HttpHost httpHost) {
        return this.mPending.containsKey(httpHost);
    }

    @Override // com.baidu.zeus.RequestFeeder
    public void requeueRequest(Request request) {
        queueRequest(request, true);
    }

    public void shutdown() {
        this.mActivePool.shutdown();
    }

    protected synchronized void queueRequest(Request request, boolean z) {
        LinkedList linkedList;
        HttpHost httpHost = request.mProxyHost == null ? request.mHost : request.mProxyHost;
        if (this.mPending.containsKey(httpHost)) {
            linkedList = (LinkedList) this.mPending.get(httpHost);
        } else {
            linkedList = new LinkedList();
            this.mPending.put(httpHost, linkedList);
        }
        if (z) {
            linkedList.addFirst(request);
        } else {
            linkedList.add(request);
        }
    }

    public void startTiming() {
        this.mActivePool.startTiming();
    }

    public void stopTiming() {
        this.mActivePool.stopTiming();
    }

    private Request removeFirst(LinkedHashMap linkedHashMap) {
        Request request = null;
        Iterator it = linkedHashMap.entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            LinkedList linkedList = (LinkedList) entry.getValue();
            request = (Request) linkedList.removeFirst();
            if (linkedList.isEmpty()) {
                linkedHashMap.remove(entry.getKey());
            }
        }
        return request;
    }
}
