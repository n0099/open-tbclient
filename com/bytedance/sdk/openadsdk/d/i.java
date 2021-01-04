package com.bytedance.sdk.openadsdk.d;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public final class i extends l implements Iterable<l> {

    /* renamed from: a  reason: collision with root package name */
    private final List<l> f7296a = new ArrayList();

    public void a(l lVar) {
        if (lVar == null) {
            lVar = n.f7297a;
        }
        this.f7296a.add(lVar);
    }

    @Override // java.lang.Iterable
    public Iterator<l> iterator() {
        return this.f7296a.iterator();
    }

    @Override // com.bytedance.sdk.openadsdk.d.l
    public Number a() {
        if (this.f7296a.size() == 1) {
            return this.f7296a.get(0).a();
        }
        throw new IllegalStateException();
    }

    @Override // com.bytedance.sdk.openadsdk.d.l
    public String b() {
        if (this.f7296a.size() == 1) {
            return this.f7296a.get(0).b();
        }
        throw new IllegalStateException();
    }

    @Override // com.bytedance.sdk.openadsdk.d.l
    public double c() {
        if (this.f7296a.size() == 1) {
            return this.f7296a.get(0).c();
        }
        throw new IllegalStateException();
    }

    @Override // com.bytedance.sdk.openadsdk.d.l
    public long d() {
        if (this.f7296a.size() == 1) {
            return this.f7296a.get(0).d();
        }
        throw new IllegalStateException();
    }

    @Override // com.bytedance.sdk.openadsdk.d.l
    public int e() {
        if (this.f7296a.size() == 1) {
            return this.f7296a.get(0).e();
        }
        throw new IllegalStateException();
    }

    @Override // com.bytedance.sdk.openadsdk.d.l
    public boolean f() {
        if (this.f7296a.size() == 1) {
            return this.f7296a.get(0).f();
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof i) && ((i) obj).f7296a.equals(this.f7296a));
    }

    public int hashCode() {
        return this.f7296a.hashCode();
    }
}
