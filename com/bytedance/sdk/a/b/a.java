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
    final SSLSocketFactory poA;
    final HostnameVerifier poB;
    final j poC;
    final s pou;
    final r pov;
    final SocketFactory pow;
    final e pox;
    final ProxySelector poy;
    final Proxy poz;

    public a(String str, int i, r rVar, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, j jVar, e eVar, Proxy proxy, List<w> list, List<n> list2, ProxySelector proxySelector) {
        this.pou = new s.a().YV(sSLSocketFactory != null ? "https" : HttpHost.DEFAULT_SCHEME_NAME).YT(str).OH(i).eqi();
        if (rVar == null) {
            throw new NullPointerException("dns == null");
        }
        this.pov = rVar;
        if (socketFactory == null) {
            throw new NullPointerException("socketFactory == null");
        }
        this.pow = socketFactory;
        if (eVar == null) {
            throw new NullPointerException("proxyAuthenticator == null");
        }
        this.pox = eVar;
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
        this.poy = proxySelector;
        this.poz = proxy;
        this.poA = sSLSocketFactory;
        this.poB = hostnameVerifier;
        this.poC = jVar;
    }

    public s eoR() {
        return this.pou;
    }

    public r eoS() {
        return this.pov;
    }

    public SocketFactory eoT() {
        return this.pow;
    }

    public e eoU() {
        return this.pox;
    }

    public List<w> e() {
        return this.e;
    }

    public List<n> f() {
        return this.f;
    }

    public ProxySelector eoV() {
        return this.poy;
    }

    public Proxy eoW() {
        return this.poz;
    }

    public SSLSocketFactory eoX() {
        return this.poA;
    }

    public HostnameVerifier eoY() {
        return this.poB;
    }

    public j eoZ() {
        return this.poC;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && this.pou.equals(((a) obj).pou) && a((a) obj);
    }

    public int hashCode() {
        return (((this.poB != null ? this.poB.hashCode() : 0) + (((this.poA != null ? this.poA.hashCode() : 0) + (((this.poz != null ? this.poz.hashCode() : 0) + ((((((((((((this.pou.hashCode() + 527) * 31) + this.pov.hashCode()) * 31) + this.pox.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.poy.hashCode()) * 31)) * 31)) * 31)) * 31) + (this.poC != null ? this.poC.hashCode() : 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(a aVar) {
        return this.pov.equals(aVar.pov) && this.pox.equals(aVar.pox) && this.e.equals(aVar.e) && this.f.equals(aVar.f) && this.poy.equals(aVar.poy) && com.bytedance.sdk.a.b.a.c.a(this.poz, aVar.poz) && com.bytedance.sdk.a.b.a.c.a(this.poA, aVar.poA) && com.bytedance.sdk.a.b.a.c.a(this.poB, aVar.poB) && com.bytedance.sdk.a.b.a.c.a(this.poC, aVar.poC) && eoR().g() == aVar.eoR().g();
    }

    public String toString() {
        StringBuilder append = new StringBuilder().append("Address{").append(this.pou.f()).append(":").append(this.pou.g());
        if (this.poz != null) {
            append.append(", proxy=").append(this.poz);
        } else {
            append.append(", proxySelector=").append(this.poy);
        }
        append.append("}");
        return append.toString();
    }
}
