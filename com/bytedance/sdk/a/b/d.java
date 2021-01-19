package com.bytedance.sdk.a.b;

import java.net.InetSocketAddress;
import java.net.Proxy;
/* loaded from: classes4.dex */
public final class d {

    /* renamed from: b  reason: collision with root package name */
    final Proxy f5956b;
    final a peq;
    final InetSocketAddress pgG;

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
        this.peq = aVar;
        this.f5956b = proxy;
        this.pgG = inetSocketAddress;
    }

    public a ens() {
        return this.peq;
    }

    public Proxy ent() {
        return this.f5956b;
    }

    public InetSocketAddress enu() {
        return this.pgG;
    }

    public boolean d() {
        return this.peq.pdK != null && this.f5956b.type() == Proxy.Type.HTTP;
    }

    public boolean equals(Object obj) {
        return (obj instanceof d) && ((d) obj).peq.equals(this.peq) && ((d) obj).f5956b.equals(this.f5956b) && ((d) obj).pgG.equals(this.pgG);
    }

    public int hashCode() {
        return ((((this.peq.hashCode() + 527) * 31) + this.f5956b.hashCode()) * 31) + this.pgG.hashCode();
    }

    public String toString() {
        return "Route{" + this.pgG + "}";
    }
}
