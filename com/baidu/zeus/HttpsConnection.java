package com.baidu.zeus;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.harmony.xnet.provider.jsse.FileClientSessionCache;
import org.apache.harmony.xnet.provider.jsse.SSLClientSessionCache;
import org.apache.harmony.xnet.provider.jsse.SSLContextImpl;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;
import org.apache.http.message.BasicHttpRequest;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
/* loaded from: classes.dex */
public class HttpsConnection extends Connection {
    private static SSLSocketFactory mSslSocketFactory = null;
    private boolean mAborted;
    private HttpHost mProxyHost;
    private Object mSuspendLock;
    private boolean mSuspended;

    public static native void engineInit(SSLContextImpl sSLContextImpl, TrustManager[] trustManagerArr, SSLClientSessionCache sSLClientSessionCache, int i);

    public static native SSLSocketFactory engineInit2(SSLContextImpl sSLContextImpl, TrustManager[] trustManagerArr, SSLClientSessionCache sSLClientSessionCache, int i);

    @Override // com.baidu.zeus.Connection
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    static {
        initializeEngine(null);
    }

    public static void initializeEngine(File file) {
        SSLClientSessionCache sSLClientSessionCache = null;
        if (file != null) {
            try {
                Log.d("HttpsConnection", "Caching SSL sessions in " + file + ".");
                sSLClientSessionCache = FileClientSessionCache.usingDirectory(file);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (KeyManagementException e2) {
                throw new RuntimeException(e2);
            }
        }
        SSLContextImpl sSLContextImpl = new SSLContextImpl();
        TrustManager[] trustManagerArr = {new X509TrustManager() { // from class: com.baidu.zeus.HttpsConnection.1
            @Override // javax.net.ssl.X509TrustManager
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }

            @Override // javax.net.ssl.X509TrustManager
            public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
            }

            @Override // javax.net.ssl.X509TrustManager
            public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            }
        }};
        int oSId = WebKitInit.getOSId();
        if (oSId < 5) {
            engineInit(sSLContextImpl, trustManagerArr, sSLClientSessionCache, WebKitInit.getOSId());
        }
        synchronized (HttpsConnection.class) {
            if (oSId >= 5) {
                mSslSocketFactory = engineInit2(sSLContextImpl, trustManagerArr, sSLClientSessionCache, WebKitInit.getOSId());
            } else {
                mSslSocketFactory = sSLContextImpl.engineGetSocketFactory();
            }
        }
    }

    private static synchronized SSLSocketFactory getSocketFactory() {
        SSLSocketFactory sSLSocketFactory;
        synchronized (HttpsConnection.class) {
            sSLSocketFactory = mSslSocketFactory;
        }
        return sSLSocketFactory;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpsConnection(Context context, HttpHost httpHost, HttpHost httpHost2, RequestFeeder requestFeeder) {
        super(context, httpHost, requestFeeder);
        this.mSuspendLock = new Object();
        this.mSuspended = false;
        this.mAborted = false;
        this.mProxyHost = httpHost2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCertificate(SslCertificate sslCertificate) {
        this.mCertificate = sslCertificate;
    }

    @Override // com.baidu.zeus.Connection
    AndroidHttpClientConnection openConnection(Request request) {
        SSLSocket sSLSocket;
        Header[] allHeaders;
        StatusLine parseResponseHeader;
        int statusCode;
        SSLSocket sSLSocket2 = null;
        AndroidHttpClientConnection androidHttpClientConnection = null;
        if (this.mProxyHost != null) {
            try {
                Socket socket = new Socket(this.mProxyHost.getHostName(), this.mProxyHost.getPort());
                socket.setSoTimeout(60000);
                AndroidHttpClientConnection androidHttpClientConnection2 = new AndroidHttpClientConnection();
                try {
                    BasicHttpParams basicHttpParams = new BasicHttpParams();
                    HttpConnectionParams.setSocketBufferSize(basicHttpParams, 8192);
                    androidHttpClientConnection2.bind(socket, basicHttpParams);
                    Headers headers = new Headers();
                    try {
                        BasicHttpRequest basicHttpRequest = new BasicHttpRequest("CONNECT", this.mHost.toHostString());
                        for (Header header : request.mHttpRequest.getAllHeaders()) {
                            String lowerCase = header.getName().toLowerCase();
                            if (lowerCase.startsWith("proxy") || lowerCase.equals("keep-alive")) {
                                basicHttpRequest.addHeader(header);
                            }
                        }
                        androidHttpClientConnection2.sendRequestHeader(basicHttpRequest);
                        androidHttpClientConnection2.flush();
                        do {
                            parseResponseHeader = androidHttpClientConnection2.parseResponseHeader(headers);
                            statusCode = parseResponseHeader.getStatusCode();
                        } while (statusCode < 200);
                        if (statusCode == 200) {
                            try {
                                sSLSocket = (SSLSocket) getSocketFactory().createSocket(socket, this.mHost.getHostName(), this.mHost.getPort(), true);
                            } catch (IOException e) {
                                if (0 != 0) {
                                    sSLSocket2.close();
                                }
                                String message = e.getMessage();
                                if (message == null) {
                                    message = "failed to create an SSL socket";
                                }
                                throw new IOException(message);
                            }
                        } else {
                            ProtocolVersion protocolVersion = parseResponseHeader.getProtocolVersion();
                            request.mEventHandler.status(protocolVersion.getMajor(), protocolVersion.getMinor(), statusCode, parseResponseHeader.getReasonPhrase());
                            request.mEventHandler.headers(headers);
                            request.mEventHandler.endData();
                            androidHttpClientConnection2.close();
                            return null;
                        }
                    } catch (IOException e2) {
                        String message2 = e2.getMessage();
                        if (message2 == null) {
                            message2 = "failed to send a CONNECT request";
                        }
                        throw new IOException(message2);
                    } catch (HttpException e3) {
                        String message3 = e3.getMessage();
                        if (message3 == null) {
                            message3 = "failed to send a CONNECT request";
                        }
                        throw new IOException(message3);
                    } catch (org.apache.http.ParseException e4) {
                        String message4 = e4.getMessage();
                        if (message4 == null) {
                            message4 = "failed to send a CONNECT request";
                        }
                        throw new IOException(message4);
                    }
                } catch (IOException e5) {
                    e = e5;
                    androidHttpClientConnection = androidHttpClientConnection2;
                    if (androidHttpClientConnection != null) {
                        androidHttpClientConnection.close();
                    }
                    String message5 = e.getMessage();
                    if (message5 == null) {
                        message5 = "failed to establish a connection to the proxy";
                    }
                    throw new IOException(message5);
                }
            } catch (IOException e6) {
                e = e6;
            }
        } else {
            try {
                sSLSocket = (SSLSocket) getSocketFactory().createSocket();
                try {
                    sSLSocket.setSoTimeout(60000);
                    sSLSocket.connect(new InetSocketAddress(this.mHost.getHostName(), this.mHost.getPort()));
                } catch (IOException e7) {
                    sSLSocket2 = sSLSocket;
                    e = e7;
                    if (sSLSocket2 != null) {
                        sSLSocket2.close();
                    }
                    String message6 = e.getMessage();
                    if (message6 == null) {
                        message6 = "failed to create an SSL socket";
                    }
                    throw new IOException(message6);
                }
            } catch (IOException e8) {
                e = e8;
            }
        }
        SslError doHandshakeAndValidateServerCertificates = CertificateChainValidator.getInstance().doHandshakeAndValidateServerCertificates(this, sSLSocket, this.mHost.getHostName());
        if (doHandshakeAndValidateServerCertificates != null) {
            synchronized (this.mSuspendLock) {
                this.mSuspended = true;
            }
            if (!request.getEventHandler().handleSslErrorRequest(doHandshakeAndValidateServerCertificates)) {
                throw new IOException("failed to handle " + doHandshakeAndValidateServerCertificates);
            }
            synchronized (this.mSuspendLock) {
                if (this.mSuspended) {
                    try {
                        this.mSuspendLock.wait(600000L);
                        if (this.mSuspended) {
                            this.mSuspended = false;
                            this.mAborted = true;
                        }
                    } catch (InterruptedException e9) {
                    }
                }
                if (this.mAborted) {
                    sSLSocket.close();
                    throw new SSLConnectionClosedByUserException("connection closed by the user");
                }
            }
        }
        AndroidHttpClientConnection androidHttpClientConnection3 = new AndroidHttpClientConnection();
        BasicHttpParams basicHttpParams2 = new BasicHttpParams();
        basicHttpParams2.setIntParameter("http.socket.buffer-size", 8192);
        androidHttpClientConnection3.bind(sSLSocket, basicHttpParams2);
        return androidHttpClientConnection3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.zeus.Connection
    public void closeConnection() {
        if (this.mSuspended) {
            restartConnection(false);
        }
        try {
            if (this.mHttpClientConnection != null && this.mHttpClientConnection.isOpen()) {
                this.mHttpClientConnection.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void restartConnection(boolean z) {
        synchronized (this.mSuspendLock) {
            if (this.mSuspended) {
                this.mSuspended = false;
                this.mAborted = z ? false : true;
                this.mSuspendLock.notify();
            }
        }
    }

    @Override // com.baidu.zeus.Connection
    String getScheme() {
        return "https";
    }
}
