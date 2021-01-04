package com.bytedance.sdk.a.b.a.c;

import com.bytedance.sdk.a.b.y;
/* loaded from: classes4.dex */
public final class h extends com.bytedance.sdk.a.b.c {

    /* renamed from: a  reason: collision with root package name */
    private final String f6179a;

    /* renamed from: b  reason: collision with root package name */
    private final long f6180b;
    private final com.bytedance.sdk.a.a.e pjC;

    public h(String str, long j, com.bytedance.sdk.a.a.e eVar) {
        this.f6179a = str;
        this.f6180b = j;
        this.pjC = eVar;
    }

    @Override // com.bytedance.sdk.a.b.c
    public y eqO() {
        if (this.f6179a != null) {
            return y.YU(this.f6179a);
        }
        return null;
    }

    @Override // com.bytedance.sdk.a.b.c
    public long b() {
        return this.f6180b;
    }

    @Override // com.bytedance.sdk.a.b.c
    public com.bytedance.sdk.a.a.e eqP() {
        return this.pjC;
    }
}
