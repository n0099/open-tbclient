package com.baidu.webkit.net;

import android.text.TextUtils;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class c implements HostnameVerifier {
    @Override // javax.net.ssl.HostnameVerifier
    public final boolean verify(String str, SSLSession sSLSession) {
        boolean matches;
        boolean z = true;
        try {
            if ((TextUtils.isEmpty(str) || !str.equals("browserkernel.baidu.com")) && (TextUtils.isEmpty(str) || !str.equals("180.76.76.112"))) {
                X509Certificate x509Certificate = (X509Certificate) sSLSession.getPeerCertificates()[0];
                matches = b.g.matcher(str).matches();
                z = matches ? b.a(str, x509Certificate) : b.b(str, x509Certificate);
            }
            return z;
        } catch (Exception e) {
            com.a.a.a.a.a.a.a.a(e);
            return HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSession);
        }
    }
}
