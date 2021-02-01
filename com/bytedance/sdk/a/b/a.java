package com.bytedance.sdk.a.b;

import com.bytedance.sdk.a.b.s;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.HttpHost;
/* loaded from: classes6.dex */
public final class a {
    final List<w> e;
    final List<n> f;
    final s pnR;
    final r pnS;
    final SocketFactory pnT;
    final e pnU;
    final ProxySelector pnV;
    final Proxy pnW;
    final SSLSocketFactory pnX;
    final HostnameVerifier pnY;
    final j pnZ;

    public a(String str, int i, r rVar, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, j jVar, e eVar, Proxy proxy, List<w> list, List<n> list2, ProxySelector proxySelector) {
        this.pnR = new s.a().YJ(sSLSocketFactory != null ? "https" : HttpHost.DEFAULT_SCHEME_NAME).YH(str).OG(i).eqa();
        if (rVar == null) {
            throw new NullPointerException("dns == null");
        }
        this.pnS = rVar;
        if (socketFactory == null) {
            throw new NullPointerException("socketFactory == null");
        }
        this.pnT = socketFactory;
        if (eVar == null) {
            throw new NullPointerException("proxyAuthenticator == null");
        }
        this.pnU = eVar;
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
        this.pnV = proxySelector;
        this.pnW = proxy;
        this.pnX = sSLSocketFactory;
        this.pnY = hostnameVerifier;
        this.pnZ = jVar;
    }

    public s eoJ() {
        return this.pnR;
    }

    public r eoK() {
        return this.pnS;
    }

    public SocketFactory eoL() {
        return this.pnT;
    }

    public e eoM() {
        return this.pnU;
    }

    public List<w> e() {
        return this.e;
    }

    public List<n> f() {
        return this.f;
    }

    public ProxySelector eoN() {
        return this.pnV;
    }

    public Proxy eoO() {
        return this.pnW;
    }

    public SSLSocketFactory eoP() {
        return this.pnX;
    }

    public HostnameVerifier eoQ() {
        return this.pnY;
    }

    public j eoR() {
        return this.pnZ;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && this.pnR.equals(((a) obj).pnR) && a((a) obj);
    }

    public int hashCode() {
        return (((this.pnY != null ? this.pnY.hashCode() : 0) + (((this.pnX != null ? this.pnX.hashCode() : 0) + (((this.pnW != null ? this.pnW.hashCode() : 0) + ((((((((((((this.pnR.hashCode() + 527) * 31) + this.pnS.hashCode()) * 31) + this.pnU.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.pnV.hashCode()) * 31)) * 31)) * 31)) * 31) + (this.pnZ != null ? this.pnZ.hashCode() : 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(a aVar) {
        return this.pnS.equals(aVar.pnS) && this.pnU.equals(aVar.pnU) && this.e.equals(aVar.e) && this.f.equals(aVar.f) && this.pnV.equals(aVar.pnV) && com.bytedance.sdk.a.b.a.c.a(this.pnW, aVar.pnW) && com.bytedance.sdk.a.b.a.c.a(this.pnX, aVar.pnX) && com.bytedance.sdk.a.b.a.c.a(this.pnY, aVar.pnY) && com.bytedance.sdk.a.b.a.c.a(this.pnZ, aVar.pnZ) && eoJ().g() == aVar.eoJ().g();
    }

    public String toString() {
        StringBuilder append = new StringBuilder().append("Address{").append(this.pnR.f()).append(":").append(this.pnR.g());
        if (this.pnW != null) {
            append.append(", proxy=").append(this.pnW);
        } else {
            append.append(", proxySelector=").append(this.pnV);
        }
        append.append("}");
        return append.toString();
    }
}
