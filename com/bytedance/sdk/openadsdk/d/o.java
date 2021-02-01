package com.bytedance.sdk.openadsdk.d;

import java.util.Map;
import java.util.Set;
/* loaded from: classes6.dex */
public final class o extends l {

    /* renamed from: a  reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.d.b.h<String, l> f7001a = new com.bytedance.sdk.openadsdk.d.b.h<>();

    public void a(String str, l lVar) {
        com.bytedance.sdk.openadsdk.d.b.h<String, l> hVar = this.f7001a;
        if (lVar == null) {
            lVar = n.f7000a;
        }
        hVar.put(str, lVar);
    }

    public Set<Map.Entry<String, l>> n() {
        return this.f7001a.entrySet();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof o) && ((o) obj).f7001a.equals(this.f7001a));
    }

    public int hashCode() {
        return this.f7001a.hashCode();
    }
}
