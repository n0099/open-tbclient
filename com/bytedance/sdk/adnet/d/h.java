package com.bytedance.sdk.adnet.d;

import android.os.Build;
import android.util.Log;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
/* loaded from: classes4.dex */
public class h extends SSLSocketFactory {

    /* renamed from: a  reason: collision with root package name */
    public static final X509TrustManager f6056a;

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f6057b;
    private SSLSocketFactory pld;

    static {
        if (Build.VERSION.SDK_INT >= 26) {
            f6057b = new String[]{"TLSv1", "TLSv1.1", "TLSv1.2"};
        } else if (Build.VERSION.SDK_INT >= 16) {
            f6057b = new String[]{"SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2"};
        } else {
            f6057b = new String[]{"SSLv3", "TLSv1"};
        }
        f6056a = new X509TrustManager() { // from class: com.bytedance.sdk.adnet.d.h.1
            @Override // javax.net.ssl.X509TrustManager
            public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
            }

            @Override // javax.net.ssl.X509TrustManager
            public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            }

            @Override // javax.net.ssl.X509TrustManager
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        };
    }

    private static void a(Socket socket) {
        if (socket instanceof SSLSocket) {
            ((SSLSocket) socket).setEnabledProtocols(f6057b);
        }
    }

    public h() {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{f6056a}, new SecureRandom());
            this.pld = sSLContext.getSocketFactory();
        } catch (Exception e) {
            Log.e("TLSSocketFactory", "TLSSocketFactory error: ", e);
        }
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        if (this.pld != null) {
            return this.pld.getDefaultCipherSuites();
        }
        return null;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        if (this.pld != null) {
            return this.pld.getSupportedCipherSuites();
        }
        return null;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        if (this.pld == null) {
            return null;
        }
        Socket createSocket = this.pld.createSocket(socket, str, i, z);
        a(createSocket);
        return createSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) throws IOException {
        if (this.pld == null) {
            return null;
        }
        Socket createSocket = this.pld.createSocket(str, i);
        a(createSocket);
        return createSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        if (this.pld == null) {
            return null;
        }
        Socket createSocket = this.pld.createSocket(str, i, inetAddress, i2);
        a(createSocket);
        return createSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        if (this.pld == null) {
            return null;
        }
        Socket createSocket = this.pld.createSocket(inetAddress, i);
        a(createSocket);
        return createSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        if (this.pld == null) {
            return null;
        }
        Socket createSocket = this.pld.createSocket(inetAddress, i, inetAddress2, i2);
        a(createSocket);
        return createSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket() throws IOException {
        if (this.pld == null) {
            return null;
        }
        Socket createSocket = this.pld.createSocket();
        a(createSocket);
        return createSocket;
    }
}
