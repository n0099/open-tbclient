package com.baidu.webkit.net;

import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
/* loaded from: classes5.dex */
public final class c implements HostnameVerifier {
    @Override // javax.net.ssl.HostnameVerifier
    public final boolean verify(String str, SSLSession sSLSession) {
        boolean verifyAsIpAddress;
        boolean verifyHostName;
        boolean verifyIpAddress;
        try {
            X509Certificate x509Certificate = (X509Certificate) sSLSession.getPeerCertificates()[0];
            verifyAsIpAddress = BdNetEngine.verifyAsIpAddress(str);
            if (verifyAsIpAddress) {
                verifyIpAddress = BdNetEngine.verifyIpAddress(str, x509Certificate);
                return verifyIpAddress;
            }
            verifyHostName = BdNetEngine.verifyHostName(str, x509Certificate);
            return verifyHostName;
        } catch (Exception e2) {
            e2.printStackTrace();
            return HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSession);
        }
    }
}
