package com.bytedance.sdk.a.b;

import java.net.InetSocketAddress;
import java.net.Proxy;
/* loaded from: classes6.dex */
public final class d {
    final Proxy b;
    final a prn;
    final InetSocketAddress ptE;

    public d(a aVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (aVar == null) {
            throw new NullPointerException("address == null");
        }
        if (proxy == null) {
            throw new NullPointerException("proxy == null");
        }
        if (inetSocketAddress == null) {
            throw new NullPointerException("inetSocketAddress == null");
        }
        this.prn = aVar;
        this.b = proxy;
        this.ptE = inetSocketAddress;
    }

    public a eqa() {
        return this.prn;
    }

    public Proxy eqb() {
        return this.b;
    }

    public InetSocketAddress eqc() {
        return this.ptE;
    }

    public boolean d() {
        return this.prn.pqH != null && this.b.type() == Proxy.Type.HTTP;
    }

    public boolean equals(Object obj) {
        return (obj instanceof d) && ((d) obj).prn.equals(this.prn) && ((d) obj).b.equals(this.b) && ((d) obj).ptE.equals(this.ptE);
    }

    public int hashCode() {
        return ((((this.prn.hashCode() + 527) * 31) + this.b.hashCode()) * 31) + this.ptE.hashCode();
    }

    public String toString() {
        return "Route{" + this.ptE + "}";
    }
}
