package com.bytedance.sdk.openadsdk.core.d;

import androidx.annotation.Nullable;
/* loaded from: classes6.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public l f27928a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f27929b;

    /* renamed from: c  reason: collision with root package name */
    public a f27930c;

    public p(a aVar, l lVar, byte[] bArr) {
        this.f27930c = aVar;
        this.f27928a = lVar;
        this.f27929b = bArr;
    }

    @Nullable
    public l a() {
        return this.f27928a;
    }

    @Nullable
    public byte[] b() {
        return this.f27929b;
    }

    @Nullable
    public a c() {
        return this.f27930c;
    }

    public void a(l lVar) {
        this.f27928a = lVar;
        if (lVar != null) {
            lVar.c(true);
        }
    }

    public void a(byte[] bArr) {
        this.f27929b = bArr;
    }
}
