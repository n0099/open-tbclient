package com.baidu.tieba.play.a;

import com.baidu.tieba.play.a.b;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
/* loaded from: classes.dex */
class c implements HostnameVerifier {
    final /* synthetic */ b.a fcr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b.a aVar) {
        this.fcr = aVar;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        return HttpsURLConnection.getDefaultHostnameVerifier().verify("httpsdns.baidu.com", sSLSession);
    }
}
