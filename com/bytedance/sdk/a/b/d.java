package com.bytedance.sdk.a.b;

import java.net.InetSocketAddress;
import java.net.Proxy;
/* loaded from: classes4.dex */
public final class d {

    /* renamed from: b  reason: collision with root package name */
    final Proxy f5956b;
    final a pep;
    final InetSocketAddress pgF;

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
        this.pep = aVar;
        this.f5956b = proxy;
        this.pgF = inetSocketAddress;
    }

    public a ens() {
        return this.pep;
    }

    public Proxy ent() {
        return this.f5956b;
    }

    public InetSocketAddress enu() {
        return this.pgF;
    }

    public boolean d() {
        return this.pep.pdJ != null && this.f5956b.type() == Proxy.Type.HTTP;
    }

    public boolean equals(Object obj) {
        return (obj instanceof d) && ((d) obj).pep.equals(this.pep) && ((d) obj).f5956b.equals(this.f5956b) && ((d) obj).pgF.equals(this.pgF);
    }

    public int hashCode() {
        return ((((this.pep.hashCode() + 527) * 31) + this.f5956b.hashCode()) * 31) + this.pgF.hashCode();
    }

    public String toString() {
        return "Route{" + this.pgF + "}";
    }
}
