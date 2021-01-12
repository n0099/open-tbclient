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
    final s pdD;
    final r pdE;
    final SocketFactory pdF;
    final e pdG;
    final ProxySelector pdH;
    final Proxy pdI;
    final SSLSocketFactory pdJ;
    final HostnameVerifier pdK;
    final j pdL;

    public a(String str, int i, r rVar, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, j jVar, e eVar, Proxy proxy, List<w> list, List<n> list2, ProxySelector proxySelector) {
        this.pdD = new s.a().XH(sSLSocketFactory != null ? "https" : HttpHost.DEFAULT_SCHEME_NAME).XF(str).Ol(i).enH();
        if (rVar == null) {
            throw new NullPointerException("dns == null");
        }
        this.pdE = rVar;
        if (socketFactory == null) {
            throw new NullPointerException("socketFactory == null");
        }
        this.pdF = socketFactory;
        if (eVar == null) {
            throw new NullPointerException("proxyAuthenticator == null");
        }
        this.pdG = eVar;
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
        this.pdH = proxySelector;
        this.pdI = proxy;
        this.pdJ = sSLSocketFactory;
        this.pdK = hostnameVerifier;
        this.pdL = jVar;
    }

    public s emp() {
        return this.pdD;
    }

    public r emq() {
        return this.pdE;
    }

    public SocketFactory emr() {
        return this.pdF;
    }

    public e ems() {
        return this.pdG;
    }

    public List<w> e() {
        return this.e;
    }

    public List<n> f() {
        return this.f;
    }

    public ProxySelector emt() {
        return this.pdH;
    }

    public Proxy emu() {
        return this.pdI;
    }

    public SSLSocketFactory emv() {
        return this.pdJ;
    }

    public HostnameVerifier emw() {
        return this.pdK;
    }

    public j emx() {
        return this.pdL;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && this.pdD.equals(((a) obj).pdD) && a((a) obj);
    }

    public int hashCode() {
        return (((this.pdK != null ? this.pdK.hashCode() : 0) + (((this.pdJ != null ? this.pdJ.hashCode() : 0) + (((this.pdI != null ? this.pdI.hashCode() : 0) + ((((((((((((this.pdD.hashCode() + 527) * 31) + this.pdE.hashCode()) * 31) + this.pdG.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.pdH.hashCode()) * 31)) * 31)) * 31)) * 31) + (this.pdL != null ? this.pdL.hashCode() : 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(a aVar) {
        return this.pdE.equals(aVar.pdE) && this.pdG.equals(aVar.pdG) && this.e.equals(aVar.e) && this.f.equals(aVar.f) && this.pdH.equals(aVar.pdH) && com.bytedance.sdk.a.b.a.c.a(this.pdI, aVar.pdI) && com.bytedance.sdk.a.b.a.c.a(this.pdJ, aVar.pdJ) && com.bytedance.sdk.a.b.a.c.a(this.pdK, aVar.pdK) && com.bytedance.sdk.a.b.a.c.a(this.pdL, aVar.pdL) && emp().g() == aVar.emp().g();
    }

    public String toString() {
        StringBuilder append = new StringBuilder().append("Address{").append(this.pdD.f()).append(":").append(this.pdD.g());
        if (this.pdI != null) {
            append.append(", proxy=").append(this.pdI);
        } else {
            append.append(", proxySelector=").append(this.pdH);
        }
        append.append("}");
        return append.toString();
    }
}
