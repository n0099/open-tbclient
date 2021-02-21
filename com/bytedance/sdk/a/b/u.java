package com.bytedance.sdk.a.b;

import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
/* loaded from: classes6.dex */
public final class u {

    /* renamed from: a  reason: collision with root package name */
    private final ad f5979a;
    private final List<Certificate> c;
    private final List<Certificate> d;
    private final k prG;

    private u(ad adVar, k kVar, List<Certificate> list, List<Certificate> list2) {
        this.f5979a = adVar;
        this.prG = kVar;
        this.c = list;
        this.d = list2;
    }

    public static u a(SSLSession sSLSession) {
        Certificate[] certificateArr;
        List emptyList;
        List emptyList2;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        }
        k YP = k.YP(cipherSuite);
        String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            throw new IllegalStateException("tlsVersion == null");
        }
        ad a2 = ad.a(protocol);
        try {
            certificateArr = sSLSession.getPeerCertificates();
        } catch (SSLPeerUnverifiedException e) {
            certificateArr = null;
        }
        if (certificateArr != null) {
            emptyList = com.bytedance.sdk.a.b.a.c.P(certificateArr);
        } else {
            emptyList = Collections.emptyList();
        }
        Certificate[] localCertificates = sSLSession.getLocalCertificates();
        if (localCertificates != null) {
            emptyList2 = com.bytedance.sdk.a.b.a.c.P(localCertificates);
        } else {
            emptyList2 = Collections.emptyList();
        }
        return new u(a2, YP, emptyList, emptyList2);
    }

    public k eqb() {
        return this.prG;
    }

    public List<Certificate> b() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof u) {
            u uVar = (u) obj;
            return this.f5979a.equals(uVar.f5979a) && this.prG.equals(uVar.prG) && this.c.equals(uVar.c) && this.d.equals(uVar.d);
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.f5979a.hashCode() + 527) * 31) + this.prG.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }
}
