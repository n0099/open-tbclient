package com.bytedance.sdk.openadsdk.core.d;

import androidx.annotation.Nullable;
/* loaded from: classes6.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public l f28113a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f28114b;

    /* renamed from: c  reason: collision with root package name */
    public a f28115c;

    public p(a aVar, l lVar, byte[] bArr) {
        this.f28115c = aVar;
        this.f28113a = lVar;
        this.f28114b = bArr;
    }

    @Nullable
    public l a() {
        return this.f28113a;
    }

    @Nullable
    public byte[] b() {
        return this.f28114b;
    }

    @Nullable
    public a c() {
        return this.f28115c;
    }

    public void a(l lVar) {
        this.f28113a = lVar;
        if (lVar != null) {
            lVar.c(true);
        }
    }

    public void a(byte[] bArr) {
        this.f28114b = bArr;
    }
}
