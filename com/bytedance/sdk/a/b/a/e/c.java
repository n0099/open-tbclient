package com.bytedance.sdk.a.b.a.e;

import okhttp3.internal.http2.Header;
/* loaded from: classes4.dex */
public final class c {
    final int i;
    public final com.bytedance.sdk.a.a.f pfl;
    public final com.bytedance.sdk.a.a.f pfm;
    public static final com.bytedance.sdk.a.a.f pfg = com.bytedance.sdk.a.a.f.a(":");

    /* renamed from: b  reason: collision with root package name */
    public static final com.bytedance.sdk.a.a.f f5890b = com.bytedance.sdk.a.a.f.a(Header.RESPONSE_STATUS_UTF8);
    public static final com.bytedance.sdk.a.a.f pfh = com.bytedance.sdk.a.a.f.a(Header.TARGET_METHOD_UTF8);
    public static final com.bytedance.sdk.a.a.f pfi = com.bytedance.sdk.a.a.f.a(Header.TARGET_PATH_UTF8);
    public static final com.bytedance.sdk.a.a.f pfj = com.bytedance.sdk.a.a.f.a(Header.TARGET_SCHEME_UTF8);
    public static final com.bytedance.sdk.a.a.f pfk = com.bytedance.sdk.a.a.f.a(Header.TARGET_AUTHORITY_UTF8);

    public c(String str, String str2) {
        this(com.bytedance.sdk.a.a.f.a(str), com.bytedance.sdk.a.a.f.a(str2));
    }

    public c(com.bytedance.sdk.a.a.f fVar, String str) {
        this(fVar, com.bytedance.sdk.a.a.f.a(str));
    }

    public c(com.bytedance.sdk.a.a.f fVar, com.bytedance.sdk.a.a.f fVar2) {
        this.pfl = fVar;
        this.pfm = fVar2;
        this.i = fVar.g() + 32 + fVar2.g();
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.pfl.equals(cVar.pfl) && this.pfm.equals(cVar.pfm);
        }
        return false;
    }

    public int hashCode() {
        return ((this.pfl.hashCode() + 527) * 31) + this.pfm.hashCode();
    }

    public String toString() {
        return com.bytedance.sdk.a.b.a.c.a("%s: %s", this.pfl.a(), this.pfm.a());
    }
}
