package com.baidu.zeus;

import android.util.Log;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Date;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import org.apache.harmony.security.provider.cert.X509CertImpl;
/* loaded from: classes.dex */
class CertificateChainValidator {
    private static final CertificateChainValidator sInstance = new CertificateChainValidator();

    public static native X509TrustManager getDefaultTrustManager(int i);

    public static CertificateChainValidator getInstance() {
        return sInstance;
    }

    private CertificateChainValidator() {
    }

    public SslError doHandshakeAndValidateServerCertificates(HttpsConnection httpsConnection, SSLSocket sSLSocket, String str) {
        boolean z;
        try {
            sSLSocket.setUseClientMode(true);
            sSLSocket.startHandshake();
        } catch (IOException e) {
            closeSocketThrowException(sSLSocket, e.getMessage(), "failed to perform SSL handshake");
        } catch (RuntimeException e2) {
            closeSocketThrowException(sSLSocket, e2.getMessage(), "CertificateException, failed to perform SSL handshake");
        }
        Certificate[] peerCertificates = sSLSocket.getSession().getPeerCertificates();
        if (peerCertificates == null || peerCertificates.length <= 0) {
            closeSocketThrowException(sSLSocket, "failed to retrieve peer certificates");
        } else if (httpsConnection != null && peerCertificates[0] != null) {
            httpsConnection.setCertificate(new SslCertificate((X509Certificate) peerCertificates[0]));
        }
        if (JniUtil.useChromiumHttpStack()) {
            return verifyServerDomainAndCertificates((X509Certificate[]) peerCertificates, str, "RSA");
        }
        X509Certificate[] x509CertificateArr = new X509Certificate[peerCertificates.length];
        for (int i = 0; i < peerCertificates.length; i++) {
            x509CertificateArr[i] = (X509Certificate) peerCertificates[i];
        }
        X509Certificate x509Certificate = x509CertificateArr[0];
        if (x509Certificate == null) {
            closeSocketThrowException(sSLSocket, "certificate for this site is null");
        } else if (!DomainNameChecker.match(x509Certificate, str)) {
            String str2 = "certificate not for this host: " + str;
            sSLSocket.getSession().invalidate();
            return new SslError(2, x509Certificate);
        }
        int length = x509CertificateArr.length;
        if (x509CertificateArr.length > 1) {
            int i2 = 0;
            while (i2 < x509CertificateArr.length) {
                int i3 = i2 + 1;
                while (true) {
                    if (i3 >= x509CertificateArr.length) {
                        z = false;
                        break;
                    } else if (!x509CertificateArr[i2].getIssuerDN().equals(x509CertificateArr[i3].getSubjectDN())) {
                        i3++;
                    } else if (i3 != i2 + 1) {
                        X509Certificate x509Certificate2 = x509CertificateArr[i3];
                        x509CertificateArr[i3] = x509CertificateArr[i2 + 1];
                        x509CertificateArr[i2 + 1] = x509Certificate2;
                        z = true;
                    } else {
                        z = true;
                    }
                }
                if (!z) {
                    break;
                }
                i2++;
            }
            length = i2 + 1;
            X509Certificate x509Certificate3 = x509CertificateArr[length - 1];
            Date date = new Date();
            if (x509Certificate3.getSubjectDN().equals(x509Certificate3.getIssuerDN()) && date.after(x509Certificate3.getNotAfter())) {
                length--;
            }
        }
        X509Certificate[] x509CertificateArr2 = new X509Certificate[length];
        for (int i4 = 0; i4 < length; i4++) {
            x509CertificateArr2[i4] = x509CertificateArr[i4];
        }
        try {
            getDefaultTrustManager(WebKitInit.getOSId()).checkServerTrusted(x509CertificateArr2, "RSA");
            return null;
        } catch (CertificateException e3) {
            sSLSocket.getSession().invalidate();
            return new SslError(3, x509Certificate);
        }
    }

    public static SslError verifyServerCertificates(byte[][] bArr, String str, String str2) {
        if (bArr == null || bArr.length == 0) {
            throw new IllegalArgumentException("bad certificate chain");
        }
        X509Certificate[] x509CertificateArr = new X509Certificate[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            try {
                x509CertificateArr[i] = new X509CertImpl(bArr[i]);
            } catch (Exception e) {
                Log.v("CertificateChainValidator", "" + e.getMessage());
            }
        }
        return verifyServerDomainAndCertificates(x509CertificateArr, str, str2);
    }

    private static SslError verifyServerDomainAndCertificates(X509Certificate[] x509CertificateArr, String str, String str2) {
        X509Certificate x509Certificate = x509CertificateArr[0];
        if (x509Certificate == null) {
            throw new IllegalArgumentException("certificate for this site is null");
        }
        if (!DomainNameChecker.match(x509Certificate, str)) {
            return new SslError(2, x509Certificate);
        }
        try {
            getDefaultTrustManager(WebKitInit.getOSId()).checkServerTrusted(x509CertificateArr, str2);
            return null;
        } catch (RuntimeException e) {
            HttpLog.e("verifyServerDomainAndCertificates RuntimeException error:" + e.getMessage());
            return new SslError(3, x509Certificate);
        } catch (CertificateException e2) {
            return new SslError(3, x509Certificate);
        }
    }

    private void closeSocketThrowException(SSLSocket sSLSocket, String str, String str2) {
        if (str == null) {
            str = str2;
        }
        closeSocketThrowException(sSLSocket, str);
    }

    private void closeSocketThrowException(SSLSocket sSLSocket, String str) {
        if (sSLSocket != null) {
            SSLSession session = sSLSocket.getSession();
            if (session != null) {
                session.invalidate();
            }
            sSLSocket.close();
        }
        throw new SSLHandshakeException(str);
    }
}
