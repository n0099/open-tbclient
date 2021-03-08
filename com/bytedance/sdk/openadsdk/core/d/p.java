package com.bytedance.sdk.openadsdk.core.d;

import androidx.annotation.Nullable;
/* loaded from: classes6.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    private l f4403a;
    private byte[] b;
    private a c;

    public p(a aVar, l lVar, byte[] bArr) {
        this.c = aVar;
        this.f4403a = lVar;
        this.b = bArr;
    }

    @Nullable
    public l a() {
        return this.f4403a;
    }

    public void a(l lVar) {
        this.f4403a = lVar;
        if (this.f4403a != null) {
            this.f4403a.c(true);
        }
    }

    @Nullable
    public byte[] b() {
        return this.b;
    }

    public void a(byte[] bArr) {
        this.b = bArr;
    }

    @Nullable
    public a c() {
        return this.c;
    }
}
