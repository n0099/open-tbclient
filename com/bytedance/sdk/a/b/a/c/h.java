package com.bytedance.sdk.a.b.a.c;

import com.bytedance.sdk.a.b.y;
/* loaded from: classes6.dex */
public final class h extends com.bytedance.sdk.a.b.c {

    /* renamed from: a  reason: collision with root package name */
    private final String f5882a;

    /* renamed from: b  reason: collision with root package name */
    private final long f5883b;
    private final com.bytedance.sdk.a.a.e ppp;

    public h(String str, long j, com.bytedance.sdk.a.a.e eVar) {
        this.f5882a = str;
        this.f5883b = j;
        this.ppp = eVar;
    }

    @Override // com.bytedance.sdk.a.b.c
    public y epn() {
        if (this.f5882a != null) {
            return y.YN(this.f5882a);
        }
        return null;
    }

    @Override // com.bytedance.sdk.a.b.c
    public long b() {
        return this.f5883b;
    }

    @Override // com.bytedance.sdk.a.b.c
    public com.bytedance.sdk.a.a.e epo() {
        return this.ppp;
    }
}
