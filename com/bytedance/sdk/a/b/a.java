package com.bytedance.sdk.a.b;

import com.bytedance.sdk.a.b.s;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.HttpHost;
/* loaded from: classes4.dex */
public final class a {
    final List<w> e;
    final List<n> f;
    final s pdE;
    final r pdF;
    final SocketFactory pdG;
    final e pdH;
    final ProxySelector pdI;
    final Proxy pdJ;
    final SSLSocketFactory pdK;
    final HostnameVerifier pdL;
    final j pdM;

    public a(String str, int i, r rVar, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, j jVar, e eVar, Proxy proxy, List<w> list, List<n> list2, ProxySelector proxySelector) {
        this.pdE = new s.a().XI(sSLSocketFactory != null ? "https" : HttpHost.DEFAULT_SCHEME_NAME).XG(str).Ol(i).enH();
        if (rVar == null) {
            throw new NullPointerException("dns == null");
        }
        this.pdF = rVar;
        if (socketFactory == null) {
            throw new NullPointerException("socketFactory == null");
        }
        this.pdG = socketFactory;
        if (eVar == null) {
            throw new NullPointerException("proxyAuthenticator == null");
        }
        this.pdH = eVar;
        if (list == null) {
            throw new NullPointerException("protocols == null");
        }
        this.e = com.bytedance.sdk.a.b.a.c.a(list);
        if (list2 == null) {
            throw new NullPointerException("connectionSpecs == null");
        }
        this.f = com.bytedance.sdk.a.b.a.c.a(list2);
        if (proxySelector == null) {
            throw new NullPointerException("proxySelector == null");
        }
        this.pdI = proxySelector;
        this.pdJ = proxy;
        this.pdK = sSLSocketFactory;
        this.pdL = hostnameVerifier;
        this.pdM = jVar;
    }

    public s emp() {
        return this.pdE;
    }

    public r emq() {
        return this.pdF;
    }

    public SocketFactory emr() {
        return this.pdG;
    }

    public e ems() {
        return this.pdH;
    }

    public List<w> e() {
        return this.e;
    }

    public List<n> f() {
        return this.f;
    }

    public ProxySelector emt() {
        return this.pdI;
    }

    public Proxy emu() {
        return this.pdJ;
    }

    public SSLSocketFactory emv() {
        return this.pdK;
    }

    public HostnameVerifier emw() {
        return this.pdL;
    }

    public j emx() {
        return this.pdM;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && this.pdE.equals(((a) obj).pdE) && a((a) obj);
    }

    public int hashCode() {
        return (((this.pdL != null ? this.pdL.hashCode() : 0) + (((this.pdK != null ? this.pdK.hashCode() : 0) + (((this.pdJ != null ? this.pdJ.hashCode() : 0) + ((((((((((((this.pdE.hashCode() + 527) * 31) + this.pdF.hashCode()) * 31) + this.pdH.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.pdI.hashCode()) * 31)) * 31)) * 31)) * 31) + (this.pdM != null ? this.pdM.hashCode() : 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(a aVar) {
        return this.pdF.equals(aVar.pdF) && this.pdH.equals(aVar.pdH) && this.e.equals(aVar.e) && this.f.equals(aVar.f) && this.pdI.equals(aVar.pdI) && com.bytedance.sdk.a.b.a.c.a(this.pdJ, aVar.pdJ) && com.bytedance.sdk.a.b.a.c.a(this.pdK, aVar.pdK) && com.bytedance.sdk.a.b.a.c.a(this.pdL, aVar.pdL) && com.bytedance.sdk.a.b.a.c.a(this.pdM, aVar.pdM) && emp().g() == aVar.emp().g();
    }

    public String toString() {
        StringBuilder append = new StringBuilder().append("Address{").append(this.pdE.f()).append(":").append(this.pdE.g());
        if (this.pdJ != null) {
            append.append(", proxy=").append(this.pdJ);
        } else {
            append.append(", proxySelector=").append(this.pdI);
        }
        append.append("}");
        return append.toString();
    }
}
