package com.baidu.webkit.net;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import com.baidu.webkit.internal.INoProGuard;
import com.baidu.webkit.net.b;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
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
/* loaded from: classes2.dex */
public class BdNet implements INoProGuard, b.InterfaceC0338b {
    public static final int CORE_POOL_SIZE = 2;
    protected static final boolean DEBUG = false;
    protected static final String LOG_TAG = "BdNet";
    public static final int MAX_POOL_SIZE = 3;
    private static final int MSG_START_ERROR = 1;
    public static final int PRIORITY_HIGHER = 0;
    public static final int PRIORITY_IDLE = 3;
    public static final int PRIORITY_LOWER = 2;
    public static final int PRIORITY_NORMAL = 1;
    private static SSLContext mSSLContext;
    private Context mContext;
    private INetListener mListener;
    private Handler mPrivateHandler;
    private Vector<BdNetTask> mTaskList;
    private Vector<f> mWorkerList;
    private int mPriority = 1;
    private int mPoolSize = 2;

    /* loaded from: classes2.dex */
    public enum HttpMethod implements INoProGuard {
        METHOD_GET,
        METHOD_POST,
        METHOD_RESUME
    }

    /* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
    public enum NetState implements INoProGuard {
        STATE_CONNECT_START,
        STATE_CONNECT_SETUP,
        STATE_DISCONNECT,
        STATE_UNKNOWN
    }

    /* loaded from: classes2.dex */
    public static class a implements X509TrustManager {
        private X509TrustManager a;
        private X509TrustManager b;

        public a(KeyStore keyStore) throws KeyStoreException {
            try {
                this.a = a(null);
                this.b = a(keyStore);
            } catch (NoSuchAlgorithmException e) {
                com.a.a.a.a.a.a.a.a(e);
            }
        }

        private static X509TrustManager a(KeyStore keyStore) throws NoSuchAlgorithmException, KeyStoreException {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore);
            return (X509TrustManager) trustManagerFactory.getTrustManagers()[0];
        }

        @Override // javax.net.ssl.X509TrustManager
        public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            try {
                this.a.checkClientTrusted(x509CertificateArr, str);
            } catch (CertificateException e) {
                this.b.checkClientTrusted(x509CertificateArr, str);
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            try {
                this.a.checkServerTrusted(x509CertificateArr, str);
            } catch (CertificateException e) {
                this.b.checkServerTrusted(x509CertificateArr, str);
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public final X509Certificate[] getAcceptedIssuers() {
            X509Certificate[] acceptedIssuers = this.a.getAcceptedIssuers();
            X509Certificate[] acceptedIssuers2 = this.b.getAcceptedIssuers();
            X509Certificate[] x509CertificateArr = (X509Certificate[]) Arrays.copyOf(acceptedIssuers, acceptedIssuers.length + acceptedIssuers2.length);
            System.arraycopy(acceptedIssuers2, 0, x509CertificateArr, acceptedIssuers.length, acceptedIssuers2.length);
            return x509CertificateArr;
        }
    }

    public BdNet(Context context) {
        this.mContext = context;
        if (e.a().c == null) {
            e.a().c = context.getApplicationContext();
        }
        this.mTaskList = new Vector<>();
        this.mWorkerList = new Vector<>();
    }

    private synchronized SSLContext getSSLContext() {
        if (mSSLContext == null) {
            try {
                createSSLContext(new ByteArrayInputStream("-----BEGIN CERTIFICATE-----\nMIIGHjCCBQagAwIBAgIQOpJyaH8MB1ovmPVhhztdnzANBgkqhkiG9w0BAQsFADB+\nMQswCQYDVQQGEwJVUzEdMBsGA1UEChMUU3ltYW50ZWMgQ29ycG9yYXRpb24xHzAd\nBgNVBAsTFlN5bWFudGVjIFRydXN0IE5ldHdvcmsxLzAtBgNVBAMTJlN5bWFudGVj\nIENsYXNzIDMgU2VjdXJlIFNlcnZlciBDQSAtIEc0MB4XDTE2MTEyODAwMDAwMFoX\nDTE3MTEyOTIzNTk1OVowgaUxCzAJBgNVBAYTAkNOMRAwDgYDVQQIDAdiZWlqaW5n\nMRAwDgYDVQQHDAdiZWlqaW5nMTkwNwYDVQQKDDBCZWlKaW5nIEJhaWR1IE5ldGNv\nbSBTY2llbmNlIFRlY2hub2xvZ3kgQ28uLCBMdGQxGjAYBgNVBAsMEVN5c3RlbSBE\nZXBhcnRtZW50MRswGQYDVQQDDBJodHRwc2Rucy5iYWlkdS5jb20wggEiMA0GCSqG\nSIb3DQEBAQUAA4IBDwAwggEKAoIBAQDDlHDBDS/0NI4U3lXXNBeXKrCZ4Qp+bGGO\n3n3o3UKRcrqRXMukRIJIimz5ywXS7Xp9u6iOFuQrbIl8s+4U1vim+Gk/fWC+zbFQ\n1IpKzxQ829n2wY+Wn4CTmTLb25uUYMIYHBGnmoGlYwHe+th8csH+AmiqcU/0qhnL\ncFicg4Kz+jDkw4e4DgzsYZl2VmwLwEO93ObVh+7NPQLaGYi824Txl7Lrlrz0Tp0+\n/Cvs6OqHZAZ9IM5H710LjUYg7zOW8NJUpx15txgSuN68fJENLF3evidpuVmEqh6z\nEPbFZv10AdGnT/SGE9bGOiZ9Dp9utis25SzZDj0A6Kj4EEnf6m/DAgMBAAGjggJu\nMIICajAdBgNVHREEFjAUghJodHRwc2Rucy5iYWlkdS5jb20wCQYDVR0TBAIwADAO\nBgNVHQ8BAf8EBAMCBaAwHQYDVR0lBBYwFAYIKwYBBQUHAwEGCCsGAQUFBwMCMGEG\nA1UdIARaMFgwVgYGZ4EMAQICMEwwIwYIKwYBBQUHAgEWF2h0dHBzOi8vZC5zeW1j\nYi5jb20vY3BzMCUGCCsGAQUFBwICMBkMF2h0dHBzOi8vZC5zeW1jYi5jb20vcnBh\nMB8GA1UdIwQYMBaAFF9gz2GQVd+EQxSKYCqy9Xr0QxjvMCsGA1UdHwQkMCIwIKAe\noByGGmh0dHA6Ly9zcy5zeW1jYi5jb20vc3MuY3JsMFcGCCsGAQUFBwEBBEswSTAf\nBggrBgEFBQcwAYYTaHR0cDovL3NzLnN5bWNkLmNvbTAmBggrBgEFBQcwAoYaaHR0\ncDovL3NzLnN5bWNiLmNvbS9zcy5jcnQwggEDBgorBgEEAdZ5AgQCBIH0BIHxAO8A\ndgDd6x0reg1PpiCLga2BaHB+Lo6dAdVciI09EcTNtuy+zAAAAVio/alhAAAEAwBH\nMEUCIHOx1xvjjYlBlICbAMjEvxjJjlWDbglXz80qo9843Lz2AiEA8/qhqzobAreN\nnlJAkpv2AdeffTdw+WVvSPizynYmaCIAdQDuS723dc5guuFCaR+r4Z5mow9+X7By\n2IMAxHuJeqj9ywAAAVio/amzAAAEAwBGMEQCICO5iGCU2t3tGs714Nzp8dhchzyM\n8r7QG/80nzTOkVbgAiBvxPJ/5vQrZXX+nr2ZeHhjCf8eN2W3g4pt/4hjNygOQzAN\nBgkqhkiG9w0BAQsFAAOCAQEAB6LQyLi2ESb5mXyPRoGnQrjjIzCQk0JkkCOUyuCI\nZB0PZh4u0mN+4YNeCRAWYZye9Aazee0DoP0qbdnAwSNBXYUVLrwf27UTk1XcQGMu\nbldFG1fpijPAx7pMAztPSitracd0lQAvSAyJojc9NCHDvVnjGqawVrwy3cUeNdrH\nsns8TnxcsZ0ykOOZTbrN+ReGc2F6AiHqNVOMua0AV+5oaI80GvGvejRlM62xxTn9\npKYPg6EG1VkbBPVm21xNcmdLbvm7V8gK7RSkSeaaYI8olvMr2HfA4uMMNm+vBmSu\nkFkOrzkxBpylfP6TF/szBTiC66gn+GVB1xAmbw795LHB7g==\n-----END CERTIFICATE-----\n".getBytes()));
            } catch (Exception e) {
                com.a.a.a.a.a.a.a.a(e);
            }
        }
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
        } catch (Exception e) {
        }
    }

    public static void releaseSSLContext() {
        mSSLContext = null;
    }

    private BdNetTask startNext(b bVar, BdNetTask bdNetTask) {
        BdNetTask pollTask = pollTask();
        BdNetTask d = e.a().d();
        f worker = bdNetTask.getWorker();
        if (d != null) {
            if (pollTask == null) {
                worker.b();
                if (this.mListener != null && isComplete()) {
                    this.mListener.onNetDownloadComplete(this);
                }
            } else if (!worker.a(pollTask)) {
                startError(pollTask);
            }
            d.getWorker().a(bVar);
            return d;
        } else if (pollTask != null) {
            worker.a = pollTask;
            worker.a(bVar);
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
                        if (a2.a != null) {
                            a2.a.clear();
                            a2.a = null;
                        }
                        int size = a2.b.size();
                        for (int i = 0; i < size; i++) {
                            b bVar2 = a2.b.get(i);
                            synchronized (bVar2.e) {
                                if (bVar2.d != null) {
                                    bVar2.d.obtainMessage(2).sendToTarget();
                                }
                            }
                        }
                        a2.b.clear();
                        releaseSSLContext();
                        BdNetTask.clearTaskPool();
                        e.c();
                    } catch (Exception e) {
                        com.a.a.a.a.a.a.a.a(e);
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
        } catch (IOException e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (KeyManagementException e2) {
            com.a.a.a.a.a.a.a.a(e2);
        } catch (KeyStoreException e3) {
            com.a.a.a.a.a.a.a.a(e3);
        } catch (NoSuchAlgorithmException e4) {
            com.a.a.a.a.a.a.a.a(e4);
        } catch (CertificateException e5) {
            com.a.a.a.a.a.a.a.a(e5);
        }
    }

    public Context getContext() {
        return this.mContext;
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

    @Override // com.baidu.webkit.net.b.InterfaceC0338b
    public BdNetTask onNetDownloadComplete(b bVar, BdNetTask bdNetTask, boolean z) {
        if (z && this.mListener != null) {
            this.mListener.onNetTaskComplete(this, bdNetTask);
        }
        BdNetTask startNext = startNext(bVar, bdNetTask);
        bdNetTask.recycle();
        return startNext;
    }

    @Override // com.baidu.webkit.net.b.InterfaceC0338b
    public void onNetDownloadError(b bVar, BdNetTask bdNetTask, NetError netError, int i) {
        if (this.mListener != null) {
            this.mListener.onNetDownloadError(this, bdNetTask, netError, i);
        }
    }

    @Override // com.baidu.webkit.net.b.InterfaceC0338b
    public void onNetDownloadStart(b bVar, BdNetTask bdNetTask) {
        if (this.mListener != null) {
            this.mListener.onNetTaskStart(this, bdNetTask);
        }
    }

    @Override // com.baidu.webkit.net.b.InterfaceC0338b
    public void onNetReceiveData(b bVar, BdNetTask bdNetTask, byte[] bArr, int i) {
        if (this.mListener != null) {
            this.mListener.onNetReceiveData(this, bdNetTask, bArr, i);
        }
    }

    @Override // com.baidu.webkit.net.b.InterfaceC0338b
    public void onNetReceiveHeaders(b bVar, BdNetTask bdNetTask) {
        if (this.mListener != null) {
            this.mListener.onNetReceiveHeaders(this, bdNetTask);
        }
    }

    @Override // com.baidu.webkit.net.b.InterfaceC0338b
    public boolean onNetRedirect(b bVar, BdNetTask bdNetTask, int i) {
        if (this.mListener != null) {
            return this.mListener.onNetRedirect(this, bdNetTask, i);
        }
        return true;
    }

    @Override // com.baidu.webkit.net.b.InterfaceC0338b
    public void onNetResponseCode(b bVar, BdNetTask bdNetTask, int i) {
        if (this.mListener != null) {
            this.mListener.onNetResponseCode(this, bdNetTask, i);
        }
    }

    @Override // com.baidu.webkit.net.b.InterfaceC0338b
    public void onNetStateChanged(b bVar, BdNetTask bdNetTask, NetState netState, int i) {
        if (this.mListener != null) {
            this.mListener.onNetStateChanged(this, bdNetTask, netState, i);
        }
    }

    @Override // com.baidu.webkit.net.b.InterfaceC0338b
    public void onNetUploadComplete(b bVar, BdNetTask bdNetTask) {
        if (this.mListener != null) {
            this.mListener.onNetUploadComplete(this, bdNetTask);
        }
    }

    @Override // com.baidu.webkit.net.b.InterfaceC0338b
    public void onNetUploadData(b bVar, BdNetTask bdNetTask, int i, int i2) {
        if (this.mListener != null) {
            this.mListener.onNetUploadData(this, bdNetTask, i, i2);
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
            if (this.mContext == null) {
                return;
            }
            this.mPrivateHandler = new com.baidu.webkit.net.a(this, this.mContext.getMainLooper());
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
