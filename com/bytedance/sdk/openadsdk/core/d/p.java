package com.bytedance.sdk.openadsdk.core.d;

import androidx.annotation.Nullable;
/* loaded from: classes5.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public l f27895a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f27896b;

    /* renamed from: c  reason: collision with root package name */
    public a f27897c;

    public p(a aVar, l lVar, byte[] bArr) {
        this.f27897c = aVar;
        this.f27895a = lVar;
        this.f27896b = bArr;
    }

    @Nullable
    public l a() {
        return this.f27895a;
    }

    @Nullable
    public byte[] b() {
        return this.f27896b;
    }

    @Nullable
    public a c() {
        return this.f27897c;
    }

    public void a(l lVar) {
        this.f27895a = lVar;
        if (lVar != null) {
            lVar.c(true);
        }
    }

    public void a(byte[] bArr) {
        this.f27896b = bArr;
    }
}
