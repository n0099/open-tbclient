package com.bytedance.sdk.a.b.a.i;

import java.security.cert.Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;
/* loaded from: classes4.dex */
public abstract class c {
    public abstract List<Certificate> u(List<Certificate> list, String str) throws SSLPeerUnverifiedException;

    public static c a(X509TrustManager x509TrustManager) {
        return com.bytedance.sdk.a.b.a.g.e.eng().a(x509TrustManager);
    }
}
