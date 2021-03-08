package com.bytedance.sdk.a.b.a.c;

import com.bytedance.sdk.a.b.y;
/* loaded from: classes6.dex */
public final class h extends com.bytedance.sdk.a.b.c {

    /* renamed from: a  reason: collision with root package name */
    private final String f3963a;
    private final long b;
    private final com.bytedance.sdk.a.a.e prV;

    public h(String str, long j, com.bytedance.sdk.a.a.e eVar) {
        this.f3963a = str;
        this.b = j;
        this.prV = eVar;
    }

    @Override // com.bytedance.sdk.a.b.c
    public y epC() {
        if (this.f3963a != null) {
            return y.Zg(this.f3963a);
        }
        return null;
    }

    @Override // com.bytedance.sdk.a.b.c
    public long b() {
        return this.b;
    }

    @Override // com.bytedance.sdk.a.b.c
    public com.bytedance.sdk.a.a.e epD() {
        return this.prV;
    }
}
