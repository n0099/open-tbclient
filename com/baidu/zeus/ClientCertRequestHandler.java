package com.baidu.zeus;

import java.security.PrivateKey;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
/* loaded from: classes.dex */
public final class ClientCertRequestHandler {
    private final BrowserFrame mBrowserFrame;
    private final int mHandle;
    private final String mHostAndPort;
    private final SslClientCertLookupTable mTable;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ClientCertRequestHandler(BrowserFrame browserFrame, int i, String str, SslClientCertLookupTable sslClientCertLookupTable) {
        this.mBrowserFrame = browserFrame;
        this.mHandle = i;
        this.mHostAndPort = str;
        this.mTable = sslClientCertLookupTable;
    }

    private static byte[][] encodeCertificates(X509Certificate[] x509CertificateArr) {
        byte[][] bArr = new byte[x509CertificateArr.length];
        for (int i = 0; i < x509CertificateArr.length; i++) {
            bArr[i] = x509CertificateArr[i].getEncoded();
        }
        return bArr;
    }

    public void proceed(PrivateKey privateKey, X509Certificate[] x509CertificateArr) {
        byte[] encoded = privateKey.getEncoded();
        try {
            byte[][] encodeCertificates = encodeCertificates(x509CertificateArr);
            this.mTable.Allow(this.mHostAndPort, encoded, encodeCertificates);
            this.mBrowserFrame.nativeSslClientCert(this.mHandle, encoded, encodeCertificates);
        } catch (CertificateEncodingException e) {
            this.mBrowserFrame.nativeSslClientCert(this.mHandle, null, null);
        }
    }

    public void ignore() {
        this.mBrowserFrame.nativeSslClientCert(this.mHandle, null, null);
    }

    public void cancel() {
        this.mTable.Deny(this.mHostAndPort);
        this.mBrowserFrame.nativeSslClientCert(this.mHandle, null, null);
    }
}
