package com.bytedance.sdk.openadsdk.core.d;

import androidx.annotation.Nullable;
/* loaded from: classes4.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    private l f6817a;

    /* renamed from: b  reason: collision with root package name */
    private byte[] f6818b;
    private a c;

    public o(a aVar, l lVar, byte[] bArr) {
        this.c = aVar;
        this.f6817a = lVar;
        this.f6818b = bArr;
    }

    @Nullable
    public l a() {
        return this.f6817a;
    }

    public void a(l lVar) {
        this.f6817a = lVar;
        if (this.f6817a != null) {
            this.f6817a.c(true);
        }
    }

    @Nullable
    public byte[] b() {
        return this.f6818b;
    }

    public void a(byte[] bArr) {
        this.f6818b = bArr;
    }

    @Nullable
    public a c() {
        return this.c;
    }
}
