package com.baidu.webkit.net;

import android.text.TextUtils;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class b implements HostnameVerifier {
    @Override // javax.net.ssl.HostnameVerifier
    public final boolean verify(String str, SSLSession sSLSession) {
        boolean verifyAsIpAddress;
        boolean verifyHostName;
        boolean verifyIpAddress;
        try {
            if (!TextUtils.isEmpty(str) && str.equals("180.76.76.112") && str.equals("240c:4006::6666")) {
                str = "httpsdns.baidu.com";
            }
            X509Certificate x509Certificate = (X509Certificate) sSLSession.getPeerCertificates()[0];
            verifyAsIpAddress = BdNetEngine.verifyAsIpAddress(str);
            if (verifyAsIpAddress) {
                verifyIpAddress = BdNetEngine.verifyIpAddress(str, x509Certificate);
                return verifyIpAddress;
            }
            verifyHostName = BdNetEngine.verifyHostName(str, x509Certificate);
            return verifyHostName;
        } catch (Exception e) {
            e.printStackTrace();
            return HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSession);
        }
    }
}
