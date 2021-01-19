package com.bytedance.sdk.a.b.a.c;

import com.bytedance.sdk.a.b.y;
/* loaded from: classes4.dex */
public final class h extends com.bytedance.sdk.a.b.c {

    /* renamed from: a  reason: collision with root package name */
    private final String f5880a;

    /* renamed from: b  reason: collision with root package name */
    private final long f5881b;
    private final com.bytedance.sdk.a.a.e peY;

    public h(String str, long j, com.bytedance.sdk.a.a.e eVar) {
        this.f5880a = str;
        this.f5881b = j;
        this.peY = eVar;
    }

    @Override // com.bytedance.sdk.a.b.c
    public y emT() {
        if (this.f5880a != null) {
            return y.XM(this.f5880a);
        }
        return null;
    }

    @Override // com.bytedance.sdk.a.b.c
    public long b() {
        return this.f5881b;
    }

    @Override // com.bytedance.sdk.a.b.c
    public com.bytedance.sdk.a.a.e emU() {
        return this.peY;
    }
}
