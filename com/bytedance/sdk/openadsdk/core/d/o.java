package com.bytedance.sdk.openadsdk.core.d;

import androidx.annotation.Nullable;
/* loaded from: classes6.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    private l f6519a;

    /* renamed from: b  reason: collision with root package name */
    private byte[] f6520b;
    private a c;

    public o(a aVar, l lVar, byte[] bArr) {
        this.c = aVar;
        this.f6519a = lVar;
        this.f6520b = bArr;
    }

    @Nullable
    public l a() {
        return this.f6519a;
    }

    public void a(l lVar) {
        this.f6519a = lVar;
        if (this.f6519a != null) {
            this.f6519a.c(true);
        }
    }

    @Nullable
    public byte[] b() {
        return this.f6520b;
    }

    public void a(byte[] bArr) {
        this.f6520b = bArr;
    }

    @Nullable
    public a c() {
        return this.c;
    }
}
