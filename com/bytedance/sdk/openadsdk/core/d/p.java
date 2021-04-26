package com.bytedance.sdk.openadsdk.core.d;

import androidx.annotation.Nullable;
/* loaded from: classes5.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public l f28754a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f28755b;

    /* renamed from: c  reason: collision with root package name */
    public a f28756c;

    public p(a aVar, l lVar, byte[] bArr) {
        this.f28756c = aVar;
        this.f28754a = lVar;
        this.f28755b = bArr;
    }

    @Nullable
    public l a() {
        return this.f28754a;
    }

    @Nullable
    public byte[] b() {
        return this.f28755b;
    }

    @Nullable
    public a c() {
        return this.f28756c;
    }

    public void a(l lVar) {
        this.f28754a = lVar;
        if (lVar != null) {
            lVar.c(true);
        }
    }

    public void a(byte[] bArr) {
        this.f28755b = bArr;
    }
}
