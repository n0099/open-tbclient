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
    final s pqB;
    final r pqC;
    final SocketFactory pqD;
    final e pqE;
    final ProxySelector pqF;
    final Proxy pqG;
    final SSLSocketFactory pqH;
    final HostnameVerifier pqI;
    final j pqJ;

    public a(String str, int i, r rVar, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, j jVar, e eVar, Proxy proxy, List<w> list, List<n> list2, ProxySelector proxySelector) {
        this.pqB = new s.a().Zc(sSLSocketFactory != null ? "https" : HttpHost.DEFAULT_SCHEME_NAME).Za(str).OL(i).eqp();
        if (rVar == null) {
            throw new NullPointerException("dns == null");
        }
        this.pqC = rVar;
        if (socketFactory == null) {
            throw new NullPointerException("socketFactory == null");
        }
        this.pqD = socketFactory;
        if (eVar == null) {
            throw new NullPointerException("proxyAuthenticator == null");
        }
        this.pqE = eVar;
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
        this.pqF = proxySelector;
        this.pqG = proxy;
        this.pqH = sSLSocketFactory;
        this.pqI = hostnameVerifier;
        this.pqJ = jVar;
    }

    public s eoY() {
        return this.pqB;
    }

    public r eoZ() {
        return this.pqC;
    }

    public SocketFactory epa() {
        return this.pqD;
    }

    public e epb() {
        return this.pqE;
    }

    public List<w> e() {
        return this.e;
    }

    public List<n> f() {
        return this.f;
    }

    public ProxySelector epc() {
        return this.pqF;
    }

    public Proxy epd() {
        return this.pqG;
    }

    public SSLSocketFactory epe() {
        return this.pqH;
    }

    public HostnameVerifier epf() {
        return this.pqI;
    }

    public j epg() {
        return this.pqJ;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && this.pqB.equals(((a) obj).pqB) && a((a) obj);
    }

    public int hashCode() {
        return (((this.pqI != null ? this.pqI.hashCode() : 0) + (((this.pqH != null ? this.pqH.hashCode() : 0) + (((this.pqG != null ? this.pqG.hashCode() : 0) + ((((((((((((this.pqB.hashCode() + 527) * 31) + this.pqC.hashCode()) * 31) + this.pqE.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.pqF.hashCode()) * 31)) * 31)) * 31)) * 31) + (this.pqJ != null ? this.pqJ.hashCode() : 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(a aVar) {
        return this.pqC.equals(aVar.pqC) && this.pqE.equals(aVar.pqE) && this.e.equals(aVar.e) && this.f.equals(aVar.f) && this.pqF.equals(aVar.pqF) && com.bytedance.sdk.a.b.a.c.a(this.pqG, aVar.pqG) && com.bytedance.sdk.a.b.a.c.a(this.pqH, aVar.pqH) && com.bytedance.sdk.a.b.a.c.a(this.pqI, aVar.pqI) && com.bytedance.sdk.a.b.a.c.a(this.pqJ, aVar.pqJ) && eoY().g() == aVar.eoY().g();
    }

    public String toString() {
        StringBuilder append = new StringBuilder().append("Address{").append(this.pqB.f()).append(":").append(this.pqB.g());
        if (this.pqG != null) {
            append.append(", proxy=").append(this.pqG);
        } else {
            append.append(", proxySelector=").append(this.pqF);
        }
        append.append("}");
        return append.toString();
    }
}
