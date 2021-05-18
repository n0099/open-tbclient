package com.bytedance.sdk.openadsdk.core.d;

import androidx.annotation.Nullable;
/* loaded from: classes6.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public l f27999a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f28000b;

    /* renamed from: c  reason: collision with root package name */
    public a f28001c;

    public p(a aVar, l lVar, byte[] bArr) {
        this.f28001c = aVar;
        this.f27999a = lVar;
        this.f28000b = bArr;
    }

    @Nullable
    public l a() {
        return this.f27999a;
    }

    @Nullable
    public byte[] b() {
        return this.f28000b;
    }

    @Nullable
    public a c() {
        return this.f28001c;
    }

    public void a(l lVar) {
        this.f27999a = lVar;
        if (lVar != null) {
            lVar.c(true);
        }
    }

    public void a(byte[] bArr) {
        this.f28000b = bArr;
    }
}
