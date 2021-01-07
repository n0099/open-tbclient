package com.bytedance.sdk.openadsdk.d;

import java.util.Map;
import java.util.Set;
/* loaded from: classes4.dex */
public final class o extends l {

    /* renamed from: a  reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.d.b.h<String, l> f7299a = new com.bytedance.sdk.openadsdk.d.b.h<>();

    public void a(String str, l lVar) {
        com.bytedance.sdk.openadsdk.d.b.h<String, l> hVar = this.f7299a;
        if (lVar == null) {
            lVar = n.f7298a;
        }
        hVar.put(str, lVar);
    }

    public Set<Map.Entry<String, l>> n() {
        return this.f7299a.entrySet();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof o) && ((o) obj).f7299a.equals(this.f7299a));
    }

    public int hashCode() {
        return this.f7299a.hashCode();
    }
}
