package com.bytedance.sdk.a.b;

import java.net.InetSocketAddress;
import java.net.Proxy;
/* loaded from: classes6.dex */
public final class d {

    /* renamed from: b  reason: collision with root package name */
    final Proxy f5958b;
    final a ppg;
    final InetSocketAddress pry;

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
        this.ppg = aVar;
        this.f5958b = proxy;
        this.pry = inetSocketAddress;
    }

    public a epT() {
        return this.ppg;
    }

    public Proxy epU() {
        return this.f5958b;
    }

    public InetSocketAddress epV() {
        return this.pry;
    }

    public boolean d() {
        return this.ppg.poA != null && this.f5958b.type() == Proxy.Type.HTTP;
    }

    public boolean equals(Object obj) {
        return (obj instanceof d) && ((d) obj).ppg.equals(this.ppg) && ((d) obj).f5958b.equals(this.f5958b) && ((d) obj).pry.equals(this.pry);
    }

    public int hashCode() {
        return ((((this.ppg.hashCode() + 527) * 31) + this.f5958b.hashCode()) * 31) + this.pry.hashCode();
    }

    public String toString() {
        return "Route{" + this.pry + "}";
    }
}
