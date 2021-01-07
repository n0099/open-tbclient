package com.bytedance.sdk.a.b.a.c;

import com.bytedance.sdk.a.b.y;
/* loaded from: classes4.dex */
public final class h extends com.bytedance.sdk.a.b.c {

    /* renamed from: a  reason: collision with root package name */
    private final String f6180a;

    /* renamed from: b  reason: collision with root package name */
    private final long f6181b;
    private final com.bytedance.sdk.a.a.e pjC;

    public h(String str, long j, com.bytedance.sdk.a.a.e eVar) {
        this.f6180a = str;
        this.f6181b = j;
        this.pjC = eVar;
    }

    @Override // com.bytedance.sdk.a.b.c
    public y eqP() {
        if (this.f6180a != null) {
            return y.YT(this.f6180a);
        }
        return null;
    }

    @Override // com.bytedance.sdk.a.b.c
    public long b() {
        return this.f6181b;
    }

    @Override // com.bytedance.sdk.a.b.c
    public com.bytedance.sdk.a.a.e eqQ() {
        return this.pjC;
    }
}
