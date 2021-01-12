package com.bytedance.sdk.openadsdk.d;

import java.util.Map;
import java.util.Set;
/* loaded from: classes4.dex */
public final class o extends l {

    /* renamed from: a  reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.d.b.h<String, l> f6999a = new com.bytedance.sdk.openadsdk.d.b.h<>();

    public void a(String str, l lVar) {
        com.bytedance.sdk.openadsdk.d.b.h<String, l> hVar = this.f6999a;
        if (lVar == null) {
            lVar = n.f6998a;
        }
        hVar.put(str, lVar);
    }

    public Set<Map.Entry<String, l>> n() {
        return this.f6999a.entrySet();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof o) && ((o) obj).f6999a.equals(this.f6999a));
    }

    public int hashCode() {
        return this.f6999a.hashCode();
    }
}
