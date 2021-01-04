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
    final s pih;
    final r pii;
    final SocketFactory pij;
    final e pik;
    final ProxySelector pil;
    final Proxy pim;
    final SSLSocketFactory pio;
    final HostnameVerifier pip;
    final j piq;

    public a(String str, int i, r rVar, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, j jVar, e eVar, Proxy proxy, List<w> list, List<n> list2, ProxySelector proxySelector) {
        this.pih = new s.a().YQ(sSLSocketFactory != null ? "https" : HttpHost.DEFAULT_SCHEME_NAME).YO(str).PS(i).erB();
        if (rVar == null) {
            throw new NullPointerException("dns == null");
        }
        this.pii = rVar;
        if (socketFactory == null) {
            throw new NullPointerException("socketFactory == null");
        }
        this.pij = socketFactory;
        if (eVar == null) {
            throw new NullPointerException("proxyAuthenticator == null");
        }
        this.pik = eVar;
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
        this.pil = proxySelector;
        this.pim = proxy;
        this.pio = sSLSocketFactory;
        this.pip = hostnameVerifier;
        this.piq = jVar;
    }

    public s eqk() {
        return this.pih;
    }

    public r eql() {
        return this.pii;
    }

    public SocketFactory eqm() {
        return this.pij;
    }

    public e eqn() {
        return this.pik;
    }

    public List<w> e() {
        return this.e;
    }

    public List<n> f() {
        return this.f;
    }

    public ProxySelector eqo() {
        return this.pil;
    }

    public Proxy eqp() {
        return this.pim;
    }

    public SSLSocketFactory eqq() {
        return this.pio;
    }

    public HostnameVerifier eqr() {
        return this.pip;
    }

    public j eqs() {
        return this.piq;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && this.pih.equals(((a) obj).pih) && a((a) obj);
    }

    public int hashCode() {
        return (((this.pip != null ? this.pip.hashCode() : 0) + (((this.pio != null ? this.pio.hashCode() : 0) + (((this.pim != null ? this.pim.hashCode() : 0) + ((((((((((((this.pih.hashCode() + 527) * 31) + this.pii.hashCode()) * 31) + this.pik.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.pil.hashCode()) * 31)) * 31)) * 31)) * 31) + (this.piq != null ? this.piq.hashCode() : 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(a aVar) {
        return this.pii.equals(aVar.pii) && this.pik.equals(aVar.pik) && this.e.equals(aVar.e) && this.f.equals(aVar.f) && this.pil.equals(aVar.pil) && com.bytedance.sdk.a.b.a.c.a(this.pim, aVar.pim) && com.bytedance.sdk.a.b.a.c.a(this.pio, aVar.pio) && com.bytedance.sdk.a.b.a.c.a(this.pip, aVar.pip) && com.bytedance.sdk.a.b.a.c.a(this.piq, aVar.piq) && eqk().g() == aVar.eqk().g();
    }

    public String toString() {
        StringBuilder append = new StringBuilder().append("Address{").append(this.pih.f()).append(":").append(this.pih.g());
        if (this.pim != null) {
            append.append(", proxy=").append(this.pim);
        } else {
            append.append(", proxySelector=").append(this.pil);
        }
        append.append("}");
        return append.toString();
    }
}
