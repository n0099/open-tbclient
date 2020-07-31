package com.baidu.webkit.net;

import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
/* loaded from: classes8.dex */
final class c implements HostnameVerifier {
    @Override // javax.net.ssl.HostnameVerifier
    public final boolean verify(String str, SSLSession sSLSession) {
        boolean verifyAsIpAddress;
        try {
            X509Certificate x509Certificate = (X509Certificate) sSLSession.getPeerCertificates()[0];
            verifyAsIpAddress = BdNetEngine.verifyAsIpAddress(str);
            return verifyAsIpAddress ? BdNetEngine.verifyIpAddress(str, x509Certificate) : BdNetEngine.verifyHostName(str, x509Certificate);
        } catch (Exception e) {
            com.a.a.a.a.a.a.a.a(e);
            return HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSession);
        }
    }
}
