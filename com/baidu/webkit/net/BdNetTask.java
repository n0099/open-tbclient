package com.baidu.webkit.net;

import android.os.AsyncTask;
import android.os.Looper;
import com.baidu.webkit.internal.INoProGuard;
import com.baidu.webkit.net.BdNet;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.net.HttpURLConnection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.net.ssl.SSLContext;
/* loaded from: classes8.dex */
public class BdNetTask implements INoProGuard {
    public static final boolean DEBUG = false;
    public static final String LOG_TAG = "BdNetTask";
    public static final int MAX_POOL_SIZE = 10;
    public static final int TIMEOUT_CONNECTION = 0;
    public static final int TIMEOUT_READ = 25000;
    public boolean isUseCorenet;
    public HttpURLConnection mConnection;
    public int mConnectionTimeOut;
    public byte[] mContent;
    public Map<String, String> mCookies;
    public boolean mFollowRedirects;
    public Map<String, String> mHeaders;
    public boolean mIsRedirect;
    public volatile boolean mIsStop;
    public BdNet.HttpMethod mMethod = BdNet.HttpMethod.METHOD_GET;
    public BdNet mNet;
    public com.baidu.webkit.net.b mNetWorker;
    public int mReadTimeOut;
    public String mRedirectUrl;
    public String mRefer;
    public Map<String, String> mResHeaders;
    public SSLContext mSSLContext;
    public Object mSetting;
    public b mTaskPriority;
    public String mUrl;
    public static final Map<String, String> NULL_ARRAY = Collections.emptyMap();
    public static Vector<BdNetTask> sTaskPool = new Vector<>();

    /* loaded from: classes8.dex */
    public static class a extends AsyncTask<HttpURLConnection, Void, Void> {
        public a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public static Void a(HttpURLConnection... httpURLConnectionArr) {
            HttpURLConnection httpURLConnection;
            if (httpURLConnectionArr != null) {
                try {
                    if (httpURLConnectionArr.length <= 0 || (httpURLConnection = httpURLConnectionArr[0]) == null) {
                        return null;
                    }
                    httpURLConnection.disconnect();
                    return null;
                } catch (Exception unused) {
                    return null;
                }
            }
            return null;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.AsyncTask
        public final /* synthetic */ Void doInBackground(HttpURLConnection[] httpURLConnectionArr) {
            return a(httpURLConnectionArr);
        }
    }

    /* loaded from: classes8.dex */
    public enum b {
        PRIORITY_HIGHER,
        PRIORITY_NORMAL,
        PRIORITY_LOWER,
        PRIORITY_IDLE
    }

    public BdNetTask() {
        Map<String, String> map = NULL_ARRAY;
        this.mHeaders = map;
        this.mResHeaders = map;
        this.mCookies = map;
        this.mReadTimeOut = 25000;
        this.mConnectionTimeOut = 0;
        this.mFollowRedirects = true;
        this.isUseCorenet = true;
        this.mTaskPriority = b.PRIORITY_NORMAL;
    }

    private void clearForRecycle() {
        stop();
        this.mUrl = null;
        this.mRedirectUrl = null;
        this.mRefer = null;
        this.mContent = null;
        this.mMethod = BdNet.HttpMethod.METHOD_GET;
        Map<String, String> map = NULL_ARRAY;
        this.mHeaders = map;
        this.mResHeaders = map;
        this.mCookies = map;
        this.mReadTimeOut = 25000;
        this.mConnectionTimeOut = 0;
        this.mIsRedirect = false;
        this.mFollowRedirects = true;
        this.mIsStop = false;
        this.mNet = null;
        this.mNetWorker = null;
        this.mConnection = null;
    }

    public static void clearTaskPool() {
        Vector<BdNetTask> vector = sTaskPool;
        if (vector != null) {
            vector.clear();
        }
    }

    private void disconnect() {
        try {
            if (this.mConnection != null) {
                this.mConnection.disconnect();
            }
        } catch (Exception unused) {
        }
    }

    public static synchronized BdNetTask obtain() {
        synchronized (BdNetTask.class) {
            if (sTaskPool.size() <= 0) {
                return new BdNetTask();
            }
            try {
                return sTaskPool.remove(0);
            } catch (Exception e) {
                e.printStackTrace();
                return new BdNetTask();
            }
        }
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
            for (String str2 : str.split(ParamableElem.DIVIDE_PARAM)) {
                String[] split = str2.split("=");
                if (split.length >= 2) {
                    this.mCookies.put(split[0], split[1]);
                }
            }
        } catch (Exception unused) {
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

    public b getTaskPriority() {
        return this.mTaskPriority;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public com.baidu.webkit.net.b getWorker() {
        return this.mNetWorker;
    }

    public boolean isFollowRedirects() {
        return this.mFollowRedirects;
    }

    public boolean isHigherPriority() {
        return this.mTaskPriority == b.PRIORITY_HIGHER;
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

    public void setRedirect(boolean z) {
        this.mIsRedirect = z;
    }

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

    public void setTaskPriority(b bVar) {
        this.mTaskPriority = bVar;
    }

    public void setUrl(String str) {
        this.mUrl = str;
    }

    public void setWorker(com.baidu.webkit.net.b bVar) {
        this.mNetWorker = bVar;
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
