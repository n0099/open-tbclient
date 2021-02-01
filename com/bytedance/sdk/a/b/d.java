package com.bytedance.sdk.a.b;

import java.net.InetSocketAddress;
import java.net.Proxy;
/* loaded from: classes6.dex */
public final class d {

    /* renamed from: b  reason: collision with root package name */
    final Proxy f5958b;
    final a poG;
    final InetSocketAddress pqY;

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
        this.poG = aVar;
        this.f5958b = proxy;
        this.pqY = inetSocketAddress;
    }

    public a epL() {
        return this.poG;
    }

    public Proxy epM() {
        return this.f5958b;
    }

    public InetSocketAddress epN() {
        return this.pqY;
    }

    public boolean d() {
        return this.poG.pnX != null && this.f5958b.type() == Proxy.Type.HTTP;
    }

    public boolean equals(Object obj) {
        return (obj instanceof d) && ((d) obj).poG.equals(this.poG) && ((d) obj).f5958b.equals(this.f5958b) && ((d) obj).pqY.equals(this.pqY);
    }

    public int hashCode() {
        return ((((this.poG.hashCode() + 527) * 31) + this.f5958b.hashCode()) * 31) + this.pqY.hashCode();
    }

    public String toString() {
        return "Route{" + this.pqY + "}";
    }
}
