package com.bytedance.sdk.openadsdk.core.d;

import androidx.annotation.Nullable;
/* loaded from: classes5.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public l f27903a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f27904b;

    /* renamed from: c  reason: collision with root package name */
    public a f27905c;

    public p(a aVar, l lVar, byte[] bArr) {
        this.f27905c = aVar;
        this.f27903a = lVar;
        this.f27904b = bArr;
    }

    @Nullable
    public l a() {
        return this.f27903a;
    }

    @Nullable
    public byte[] b() {
        return this.f27904b;
    }

    @Nullable
    public a c() {
        return this.f27905c;
    }

    public void a(l lVar) {
        this.f27903a = lVar;
        if (lVar != null) {
            lVar.c(true);
        }
    }

    public void a(byte[] bArr) {
        this.f27904b = bArr;
    }
}
