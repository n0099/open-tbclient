package com.baidu.webkit.net;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import com.baidu.webkit.internal.INoProGuard;
import com.baidu.webkit.net.BdNetEngine;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
/* loaded from: classes5.dex */
public class BdNet implements INoProGuard, BdNetEngine.b {
    public static final int CORE_POOL_SIZE = 2;
    public static final boolean DEBUG = false;
    public static final String LOG_TAG = "BdNet";
    public static final int MAX_POOL_SIZE = 3;
    public static final int MSG_START_ERROR = 1;
    public static final int PRIORITY_HIGHER = 0;
    public static final int PRIORITY_IDLE = 3;
    public static final int PRIORITY_LOWER = 2;
    public static final int PRIORITY_NORMAL = 1;
    public static SSLContext mSSLContext;
    public WeakReference<Context> mContext;
    public INetListener mListener;
    public Handler mPrivateHandler;
    public Vector<BdNetTask> mTaskList;
    public Vector<f> mWorkerList;
    public int mPriority = 1;
    public int mPoolSize = 2;

    /* loaded from: classes5.dex */
    public enum HttpMethod implements INoProGuard {
        METHOD_GET,
        METHOD_POST,
        METHOD_RESUME
    }

    /* loaded from: classes5.dex */
    public enum NetError implements INoProGuard {
        ERROR_RUN_START,
        ERROR_RUN_EXCEPTION,
        ERROR_RUN_STOP,
        ERROR_HTTP,
        ERROR_REDIRECT,
        ERROR_MALFORMEDURL,
        ERROR_CONNECT_TIMEOUT,
        ERROR_IO,
        ERROR_UNKNOWN
    }

    /* loaded from: classes5.dex */
    public enum NetState implements INoProGuard {
        STATE_CONNECT_START,
        STATE_CONNECT_SETUP,
        STATE_DISCONNECT,
        STATE_UNKNOWN
    }

    /* loaded from: classes5.dex */
    public static class a implements X509TrustManager {

        /* renamed from: a  reason: collision with root package name */
        public X509TrustManager f27029a;

        /* renamed from: b  reason: collision with root package name */
        public X509TrustManager f27030b;

        public a(KeyStore keyStore) throws KeyStoreException {
            try {
                this.f27029a = a(null);
                this.f27030b = a(keyStore);
            } catch (NoSuchAlgorithmException e2) {
                e2.printStackTrace();
            }
        }

        public static X509TrustManager a(KeyStore keyStore) throws NoSuchAlgorithmException, KeyStoreException {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore);
            return (X509TrustManager) trustManagerFactory.getTrustManagers()[0];
        }

        @Override // javax.net.ssl.X509TrustManager
        public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            try {
                this.f27029a.checkClientTrusted(x509CertificateArr, str);
            } catch (CertificateException unused) {
                this.f27030b.checkClientTrusted(x509CertificateArr, str);
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            try {
                this.f27029a.checkServerTrusted(x509CertificateArr, str);
            } catch (CertificateException unused) {
                this.f27030b.checkServerTrusted(x509CertificateArr, str);
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public final X509Certificate[] getAcceptedIssuers() {
            X509Certificate[] acceptedIssuers = this.f27029a.getAcceptedIssuers();
            X509Certificate[] acceptedIssuers2 = this.f27030b.getAcceptedIssuers();
            X509Certificate[] x509CertificateArr = (X509Certificate[]) Arrays.copyOf(acceptedIssuers, acceptedIssuers.length + acceptedIssuers2.length);
            System.arraycopy(acceptedIssuers2, 0, x509CertificateArr, acceptedIssuers.length, acceptedIssuers2.length);
            return x509CertificateArr;
        }
    }

    public BdNet(Context context) {
        this.mContext = new WeakReference<>(context);
        if (e.a().f27051c == null) {
            e.a().f27051c = getContext().getApplicationContext();
        }
        this.mTaskList = new Vector<>();
        this.mWorkerList = new Vector<>();
    }

    private synchronized SSLContext getSSLContext() {
        return mSSLContext;
    }

    private boolean isComplete() {
        int size = this.mWorkerList.size();
        for (int i = 0; i < size; i++) {
            if (this.mWorkerList.get(i).a()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStartError(BdNetTask bdNetTask) {
        try {
            if (this.mListener != null) {
                this.mListener.onNetDownloadError(this, bdNetTask, NetError.ERROR_RUN_START, 0);
            }
        } catch (Exception unused) {
        }
    }

    public static void releaseSSLContext() {
        mSSLContext = null;
    }

    private BdNetTask startNext(BdNetEngine bdNetEngine, BdNetTask bdNetTask) {
        BdNetTask pollTask = pollTask();
        BdNetTask d2 = e.a().d();
        f worker = bdNetTask.getWorker();
        if (d2 != null) {
            if (pollTask == null) {
                worker.b();
                if (this.mListener != null && isComplete()) {
                    this.mListener.onNetDownloadComplete(this);
                }
            } else if (!worker.a(pollTask)) {
                startError(pollTask);
            }
            d2.getWorker().a(bdNetEngine);
            return d2;
        } else if (pollTask != null) {
            worker.f27053a = pollTask;
            worker.a(bdNetEngine);
            pollTask.setWorker(worker);
            return pollTask;
        } else {
            worker.b();
            if (this.mListener != null && isComplete()) {
                this.mListener.onNetDownloadComplete(this);
            }
            if (isComplete()) {
                e.a();
                if (e.b()) {
                    e a2 = e.a();
                    try {
                        if (a2.f27049a != null) {
                            a2.f27049a.clear();
                            a2.f27049a = null;
                        }
                        int size = a2.f27050b.size();
                        for (int i = 0; i < size; i++) {
                            a2.f27050b.get(i).stopDownload();
                        }
                        a2.f27050b.clear();
                        releaseSSLContext();
                        BdNetTask.clearTaskPool();
                        e.c();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
            return null;
        }
    }

    public void createSSLContext(InputStream inputStream) {
        if (inputStream == null) {
            return;
        }
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            try {
                Certificate generateCertificate = certificateFactory.generateCertificate(bufferedInputStream);
                bufferedInputStream.close();
                KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
                keyStore.load(null, null);
                keyStore.setCertificateEntry("ca4", generateCertificate);
                a aVar = new a(keyStore);
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                mSSLContext = sSLContext;
                sSLContext.init(null, new TrustManager[]{aVar}, null);
            } catch (Throwable th) {
                bufferedInputStream.close();
                throw th;
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (KeyManagementException e3) {
            e3.printStackTrace();
        } catch (KeyStoreException e4) {
            e4.printStackTrace();
        } catch (NoSuchAlgorithmException e5) {
            e5.printStackTrace();
        } catch (CertificateException e6) {
            e6.printStackTrace();
        }
    }

    public Context getContext() {
        return this.mContext.get();
    }

    public int getPriority() {
        return this.mPriority;
    }

    public BdNetTask obtainTask() {
        return BdNetTask.obtain(this);
    }

    public BdNetTask obtainTask(String str) {
        return BdNetTask.obtain(this, str);
    }

    @Override // com.baidu.webkit.net.BdNetEngine.b
    public BdNetTask onNetDownloadComplete(BdNetEngine bdNetEngine, BdNetTask bdNetTask, boolean z) {
        INetListener iNetListener;
        if (z && (iNetListener = this.mListener) != null) {
            iNetListener.onNetTaskComplete(this, bdNetTask);
        }
        BdNetTask startNext = startNext(bdNetEngine, bdNetTask);
        bdNetTask.recycle();
        return startNext;
    }

    @Override // com.baidu.webkit.net.BdNetEngine.b
    public void onNetDownloadError(BdNetEngine bdNetEngine, BdNetTask bdNetTask, NetError netError, int i) {
        INetListener iNetListener = this.mListener;
        if (iNetListener != null) {
            iNetListener.onNetDownloadError(this, bdNetTask, netError, i);
        }
    }

    @Override // com.baidu.webkit.net.BdNetEngine.b
    public void onNetDownloadStart(BdNetEngine bdNetEngine, BdNetTask bdNetTask) {
        INetListener iNetListener = this.mListener;
        if (iNetListener != null) {
            iNetListener.onNetTaskStart(this, bdNetTask);
        }
    }

    @Override // com.baidu.webkit.net.BdNetEngine.b
    public void onNetReceiveData(BdNetEngine bdNetEngine, BdNetTask bdNetTask, byte[] bArr, int i) {
        INetListener iNetListener = this.mListener;
        if (iNetListener != null) {
            iNetListener.onNetReceiveData(this, bdNetTask, bArr, i);
        }
    }

    @Override // com.baidu.webkit.net.BdNetEngine.b
    public void onNetReceiveHeaders(BdNetEngine bdNetEngine, BdNetTask bdNetTask) {
        INetListener iNetListener = this.mListener;
        if (iNetListener != null) {
            iNetListener.onNetReceiveHeaders(this, bdNetTask);
        }
    }

    @Override // com.baidu.webkit.net.BdNetEngine.b
    public boolean onNetRedirect(BdNetEngine bdNetEngine, BdNetTask bdNetTask, int i) {
        INetListener iNetListener = this.mListener;
        if (iNetListener != null) {
            return iNetListener.onNetRedirect(this, bdNetTask, i);
        }
        return true;
    }

    @Override // com.baidu.webkit.net.BdNetEngine.b
    public void onNetResponseCode(BdNetEngine bdNetEngine, BdNetTask bdNetTask, int i) {
        INetListener iNetListener = this.mListener;
        if (iNetListener != null) {
            iNetListener.onNetResponseCode(this, bdNetTask, i);
        }
    }

    @Override // com.baidu.webkit.net.BdNetEngine.b
    public void onNetStateChanged(BdNetEngine bdNetEngine, BdNetTask bdNetTask, NetState netState, int i) {
        INetListener iNetListener = this.mListener;
        if (iNetListener != null) {
            iNetListener.onNetStateChanged(this, bdNetTask, netState, i);
        }
    }

    @Override // com.baidu.webkit.net.BdNetEngine.b
    public void onNetUploadComplete(BdNetEngine bdNetEngine, BdNetTask bdNetTask) {
        INetListener iNetListener = this.mListener;
        if (iNetListener != null) {
            iNetListener.onNetUploadComplete(this, bdNetTask);
        }
    }

    @Override // com.baidu.webkit.net.BdNetEngine.b
    public void onNetUploadData(BdNetEngine bdNetEngine, BdNetTask bdNetTask, int i, int i2) {
        INetListener iNetListener = this.mListener;
        if (iNetListener != null) {
            iNetListener.onNetUploadData(this, bdNetTask, i, i2);
        }
    }

    public BdNetTask peekTask() {
        if (this.mTaskList.size() > 0) {
            return this.mTaskList.get(0);
        }
        return null;
    }

    public BdNetTask pollTask() {
        if (this.mTaskList.size() > 0) {
            return this.mTaskList.remove(0);
        }
        return null;
    }

    public void setEventListener(INetListener iNetListener) {
        this.mListener = iNetListener;
    }

    public void setPoolSize(int i) {
        if (i <= 0 || i > 3) {
            return;
        }
        this.mPoolSize = i;
    }

    public void setPriority(int i) {
        if (i < 0 || i > 3) {
            return;
        }
        this.mPriority = i;
    }

    public void start(BdNetTask bdNetTask) throws NullPointerException {
        start(bdNetTask, true);
    }

    public void start(BdNetTask bdNetTask, boolean z) throws NullPointerException {
        if (bdNetTask == null) {
            throw new NullPointerException("start nettask null");
        }
        if (z) {
            bdNetTask.setSSLContext(getSSLContext());
        }
        Iterator<f> it = this.mWorkerList.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!next.a()) {
                if (next.a(bdNetTask)) {
                    return;
                }
                startError(bdNetTask);
                return;
            }
        }
        if (this.mWorkerList.size() >= this.mPoolSize) {
            this.mTaskList.add(bdNetTask);
            return;
        }
        f fVar = new f(this);
        this.mWorkerList.add(fVar);
        fVar.a(bdNetTask);
    }

    @SuppressLint({"HandlerLeak"})
    public void startError(BdNetTask bdNetTask) {
        if (this.mPrivateHandler == null) {
            if (getContext() == null) {
                return;
            }
            this.mPrivateHandler = new com.baidu.webkit.net.a(this, getContext().getMainLooper());
        }
        this.mPrivateHandler.obtainMessage(1, bdNetTask).sendToTarget();
    }

    public void stop() {
        Iterator<f> it = this.mWorkerList.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
        this.mWorkerList.clear();
        this.mTaskList.clear();
        this.mListener = null;
    }
}
