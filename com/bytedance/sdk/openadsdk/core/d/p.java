package com.bytedance.sdk.openadsdk.core.d;

import androidx.annotation.Nullable;
/* loaded from: classes6.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public l f28031a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f28032b;

    /* renamed from: c  reason: collision with root package name */
    public a f28033c;

    public p(a aVar, l lVar, byte[] bArr) {
        this.f28033c = aVar;
        this.f28031a = lVar;
        this.f28032b = bArr;
    }

    @Nullable
    public l a() {
        return this.f28031a;
    }

    @Nullable
    public byte[] b() {
        return this.f28032b;
    }

    @Nullable
    public a c() {
        return this.f28033c;
    }

    public void a(l lVar) {
        this.f28031a = lVar;
        if (lVar != null) {
            lVar.c(true);
        }
    }

    public void a(byte[] bArr) {
        this.f28032b = bArr;
    }
}
