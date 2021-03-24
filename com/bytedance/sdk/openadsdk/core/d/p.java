package com.bytedance.sdk.openadsdk.core.d;

import androidx.annotation.Nullable;
/* loaded from: classes6.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public l f28209a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f28210b;

    /* renamed from: c  reason: collision with root package name */
    public a f28211c;

    public p(a aVar, l lVar, byte[] bArr) {
        this.f28211c = aVar;
        this.f28209a = lVar;
        this.f28210b = bArr;
    }

    @Nullable
    public l a() {
        return this.f28209a;
    }

    @Nullable
    public byte[] b() {
        return this.f28210b;
    }

    @Nullable
    public a c() {
        return this.f28211c;
    }

    public void a(l lVar) {
        this.f28209a = lVar;
        if (lVar != null) {
            lVar.c(true);
        }
    }

    public void a(byte[] bArr) {
        this.f28210b = bArr;
    }
}
