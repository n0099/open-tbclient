package com.bytedance.sdk.a.b;

import java.net.InetSocketAddress;
import java.net.Proxy;
/* loaded from: classes4.dex */
public final class d {

    /* renamed from: b  reason: collision with root package name */
    final Proxy f6256b;
    final a piU;
    final InetSocketAddress pll;

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
        this.piU = aVar;
        this.f6256b = proxy;
        this.pll = inetSocketAddress;
    }

    public a ern() {
        return this.piU;
    }

    public Proxy ero() {
        return this.f6256b;
    }

    public InetSocketAddress erp() {
        return this.pll;
    }

    public boolean d() {
        return this.piU.pio != null && this.f6256b.type() == Proxy.Type.HTTP;
    }

    public boolean equals(Object obj) {
        return (obj instanceof d) && ((d) obj).piU.equals(this.piU) && ((d) obj).f6256b.equals(this.f6256b) && ((d) obj).pll.equals(this.pll);
    }

    public int hashCode() {
        return ((((this.piU.hashCode() + 527) * 31) + this.f6256b.hashCode()) * 31) + this.pll.hashCode();
    }

    public String toString() {
        return "Route{" + this.pll + "}";
    }
}
