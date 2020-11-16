package com.baidu.webkit.net;

import android.os.AsyncTask;
import android.os.Looper;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.webkit.internal.ETAG;
import com.baidu.webkit.internal.INoProGuard;
import com.baidu.webkit.net.BdNet;
import java.net.HttpURLConnection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.net.ssl.SSLContext;
/* loaded from: classes5.dex */
public class BdNetTask implements INoProGuard {
    private static final boolean DEBUG = false;
    private static final int MAX_POOL_SIZE = 10;
    public static final int TIMEOUT_CONNECTION = 0;
    public static final int TIMEOUT_READ = 25000;
    private HttpURLConnection mConnection;
    private byte[] mContent;
    private boolean mIsRedirect;
    private volatile boolean mIsStop;
    private BdNet mNet;
    private f mNetWorker;
    private String mRedirectUrl;
    private String mRefer;
    private SSLContext mSSLContext;
    private Object mSetting;
    private String mUrl;
    private static final String LOG_TAG = BdNetTask.class.getSimpleName();
    private static final Map<String, String> NULL_ARRAY = Collections.emptyMap();
    private static Vector<BdNetTask> sTaskPool = new Vector<>();
    private BdNet.HttpMethod mMethod = BdNet.HttpMethod.METHOD_GET;
    private Map<String, String> mHeaders = NULL_ARRAY;
    private Map<String, String> mResHeaders = NULL_ARRAY;
    private Map<String, String> mCookies = NULL_ARRAY;
    private int mReadTimeOut = TIMEOUT_READ;
    private int mConnectionTimeOut = 0;
    private boolean mFollowRedirects = true;
    private boolean isUseCorenet = true;
    private int mTaskPriority$77d0b2dd = b.b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a extends AsyncTask<HttpURLConnection, Void, Void> {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        private static Void a(HttpURLConnection... httpURLConnectionArr) {
            HttpURLConnection httpURLConnection;
            if (httpURLConnectionArr != null) {
                try {
                    if (httpURLConnectionArr.length <= 0 || (httpURLConnection = httpURLConnectionArr[0]) == null) {
                        return null;
                    }
                    httpURLConnection.disconnect();
                    return null;
                } catch (Exception e) {
                    return null;
                }
            }
            return null;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.AsyncTask
        protected final /* synthetic */ Void doInBackground(HttpURLConnection[] httpURLConnectionArr) {
            return a(httpURLConnectionArr);
        }
    }

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public static final int f3970a = 1;
        public static final int b = 2;
        public static final int c = 3;
        public static final int d = 4;
        private static final /* synthetic */ int[] e = {f3970a, b, c, d};
    }

    private void clearForRecycle() {
        stop();
        this.mUrl = null;
        this.mRedirectUrl = null;
        this.mRefer = null;
        this.mContent = null;
        this.mMethod = BdNet.HttpMethod.METHOD_GET;
        this.mHeaders = NULL_ARRAY;
        this.mResHeaders = NULL_ARRAY;
        this.mCookies = NULL_ARRAY;
        this.mReadTimeOut = TIMEOUT_READ;
        this.mConnectionTimeOut = 0;
        this.mIsRedirect = false;
        this.mFollowRedirects = true;
        this.mIsStop = false;
        this.mNet = null;
        this.mNetWorker = null;
        this.mConnection = null;
    }

    public static void clearTaskPool() {
        if (sTaskPool != null) {
            sTaskPool.clear();
        }
    }

    private void disconnect() {
        try {
            if (this.mConnection != null) {
                this.mConnection.disconnect();
            }
        } catch (Exception e) {
        }
    }

    public static synchronized BdNetTask obtain() {
        BdNetTask bdNetTask;
        synchronized (BdNetTask.class) {
            if (sTaskPool.size() > 0) {
                try {
                    bdNetTask = sTaskPool.remove(0);
                } catch (Exception e) {
                    e.printStackTrace();
                    bdNetTask = new BdNetTask();
                }
            } else {
                bdNetTask = new BdNetTask();
            }
        }
        return bdNetTask;
    }

    public static BdNetTask obtain(BdNet bdNet) {
        BdNetTask obtain = obtain();
        obtain.setNet(bdNet);
        return obtain;
    }

    public static BdNetTask obtain(BdNet bdNet, String str) {
        BdNetTask obtain = obtain();
        obtain.setNet(bdNet);
        obtain.setUrl(str);
        return obtain;
    }

    public void addCookies(String str) {
        try {
            if (this.mCookies == NULL_ARRAY) {
                this.mCookies = new HashMap();
            }
            for (String str2 : str.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR)) {
                String[] split = str2.split(ETAG.EQUAL);
                if (split.length >= 2) {
                    this.mCookies.put(split[0], split[1]);
                }
            }
        } catch (Exception e) {
        }
    }

    public void addCookies(String str, String str2) {
        if (this.mCookies == NULL_ARRAY) {
            this.mCookies = new HashMap();
        }
        this.mCookies.put(str, str2);
    }

    public void addHeaders(String str, String str2) {
        if (this.mHeaders == NULL_ARRAY) {
            this.mHeaders = new HashMap();
        }
        this.mHeaders.put(str, str2);
    }

    public void addResHeaders(String str, String str2) {
        if (this.mResHeaders == NULL_ARRAY) {
            this.mResHeaders = new HashMap();
        }
        this.mResHeaders.put(str, str2);
    }

    public HttpURLConnection getConnection() {
        return this.mConnection;
    }

    public int getConnectionTimeOut() {
        return this.mConnectionTimeOut;
    }

    public byte[] getContent() {
        return (byte[]) this.mContent.clone();
    }

    public Map<String, String> getCookies() {
        return this.mCookies;
    }

    public Map<String, String> getHeaders() {
        return this.mHeaders;
    }

    public BdNet.HttpMethod getMethod() {
        return this.mMethod;
    }

    public synchronized BdNet getNet() {
        return this.mNet;
    }

    public int getReadTimeOut() {
        return this.mReadTimeOut;
    }

    public String getRedirectUrl() {
        return this.mRedirectUrl;
    }

    public String getRefer() {
        return this.mRefer;
    }

    public Map<String, String> getResHeaders() {
        return this.mResHeaders;
    }

    public SSLContext getSSLContext() {
        return this.mSSLContext;
    }

    public Object getSetting() {
        return this.mSetting;
    }

    public int getTaskPriority$78f3a484() {
        return this.mTaskPriority$77d0b2dd;
    }

    public String getUrl() {
        return this.mUrl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f getWorker() {
        return this.mNetWorker;
    }

    public boolean isFollowRedirects() {
        return this.mFollowRedirects;
    }

    public boolean isHigherPriority() {
        return this.mTaskPriority$77d0b2dd == b.f3970a;
    }

    public boolean isRedirect() {
        return this.mIsRedirect;
    }

    public boolean isStop() {
        return this.mIsStop;
    }

    public boolean isUseCorenet() {
        return this.isUseCorenet;
    }

    public synchronized void recycle() {
        if (sTaskPool.size() < 10) {
            clearForRecycle();
            sTaskPool.add(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setConnection(HttpURLConnection httpURLConnection) {
        this.mConnection = httpURLConnection;
    }

    public void setConnectionTimeOut(int i) {
        this.mConnectionTimeOut = i;
    }

    public void setContent(byte[] bArr) {
        if (bArr != null) {
            this.mContent = (byte[]) bArr.clone();
        }
    }

    public void setCookies(Map<String, String> map) {
        this.mCookies = map;
    }

    public void setFollowRedirects(boolean z) {
        this.mFollowRedirects = z;
    }

    public void setHeaders(Map<String, String> map) {
        this.mHeaders = map;
    }

    public void setIsUseCorenet(boolean z) {
        this.isUseCorenet = z;
    }

    public void setMethod(BdNet.HttpMethod httpMethod) {
        this.mMethod = httpMethod;
    }

    public synchronized void setNet(BdNet bdNet) {
        this.mNet = bdNet;
    }

    public void setReadTimeOut(int i) {
        this.mReadTimeOut = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setRedirect(boolean z) {
        this.mIsRedirect = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setRedirectUrl(String str) {
        this.mRedirectUrl = str;
    }

    public void setRefer(String str) {
        this.mRefer = str;
    }

    public void setSSLContext(SSLContext sSLContext) {
        this.mSSLContext = sSLContext;
    }

    public void setSetting(Object obj) {
        this.mSetting = obj;
    }

    public void setTaskPriority$31e7403e(int i) {
        this.mTaskPriority$77d0b2dd = i;
    }

    public void setUrl(String str) {
        this.mUrl = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setWorker(f fVar) {
        this.mNetWorker = fVar;
    }

    public synchronized void start() {
        if (this.mNet != null) {
            this.mIsStop = false;
            this.mNet.start(this);
        }
    }

    public void stop() {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            disconnect();
        } else if (this.mConnection != null) {
            new a((byte) 0).execute(this.mConnection);
        }
        this.mIsStop = true;
        this.mConnection = null;
    }
}
