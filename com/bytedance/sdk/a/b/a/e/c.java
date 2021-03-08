package com.bytedance.sdk.a.b.a.e;

import okhttp3.internal.http2.Header;
/* loaded from: classes6.dex */
public final class c {
    final int i;
    public final com.bytedance.sdk.a.a.f psi;
    public final com.bytedance.sdk.a.a.f psj;
    public static final com.bytedance.sdk.a.a.f psd = com.bytedance.sdk.a.a.f.a(":");
    public static final com.bytedance.sdk.a.a.f b = com.bytedance.sdk.a.a.f.a(Header.RESPONSE_STATUS_UTF8);
    public static final com.bytedance.sdk.a.a.f pse = com.bytedance.sdk.a.a.f.a(Header.TARGET_METHOD_UTF8);
    public static final com.bytedance.sdk.a.a.f psf = com.bytedance.sdk.a.a.f.a(Header.TARGET_PATH_UTF8);
    public static final com.bytedance.sdk.a.a.f psg = com.bytedance.sdk.a.a.f.a(Header.TARGET_SCHEME_UTF8);
    public static final com.bytedance.sdk.a.a.f psh = com.bytedance.sdk.a.a.f.a(Header.TARGET_AUTHORITY_UTF8);

    public c(String str, String str2) {
        this(com.bytedance.sdk.a.a.f.a(str), com.bytedance.sdk.a.a.f.a(str2));
    }

    public c(com.bytedance.sdk.a.a.f fVar, String str) {
        this(fVar, com.bytedance.sdk.a.a.f.a(str));
    }

    public c(com.bytedance.sdk.a.a.f fVar, com.bytedance.sdk.a.a.f fVar2) {
        this.psi = fVar;
        this.psj = fVar2;
        this.i = fVar.g() + 32 + fVar2.g();
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.psi.equals(cVar.psi) && this.psj.equals(cVar.psj);
        }
        return false;
    }

    public int hashCode() {
        return ((this.psi.hashCode() + 527) * 31) + this.psj.hashCode();
    }

    public String toString() {
        return com.bytedance.sdk.a.b.a.c.a("%s: %s", this.psi.a(), this.psj.a());
    }
}
