package com.bytedance.sdk.a.b.a.e;

import okhttp3.internal.http2.Header;
/* loaded from: classes6.dex */
public final class c {
    final int i;
    public final com.bytedance.sdk.a.a.f pqd;
    public final com.bytedance.sdk.a.a.f pqe;
    public static final com.bytedance.sdk.a.a.f ppY = com.bytedance.sdk.a.a.f.a(":");

    /* renamed from: b  reason: collision with root package name */
    public static final com.bytedance.sdk.a.a.f f5892b = com.bytedance.sdk.a.a.f.a(Header.RESPONSE_STATUS_UTF8);
    public static final com.bytedance.sdk.a.a.f ppZ = com.bytedance.sdk.a.a.f.a(Header.TARGET_METHOD_UTF8);
    public static final com.bytedance.sdk.a.a.f pqa = com.bytedance.sdk.a.a.f.a(Header.TARGET_PATH_UTF8);
    public static final com.bytedance.sdk.a.a.f pqb = com.bytedance.sdk.a.a.f.a(Header.TARGET_SCHEME_UTF8);
    public static final com.bytedance.sdk.a.a.f pqc = com.bytedance.sdk.a.a.f.a(Header.TARGET_AUTHORITY_UTF8);

    public c(String str, String str2) {
        this(com.bytedance.sdk.a.a.f.a(str), com.bytedance.sdk.a.a.f.a(str2));
    }

    public c(com.bytedance.sdk.a.a.f fVar, String str) {
        this(fVar, com.bytedance.sdk.a.a.f.a(str));
    }

    public c(com.bytedance.sdk.a.a.f fVar, com.bytedance.sdk.a.a.f fVar2) {
        this.pqd = fVar;
        this.pqe = fVar2;
        this.i = fVar.g() + 32 + fVar2.g();
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.pqd.equals(cVar.pqd) && this.pqe.equals(cVar.pqe);
        }
        return false;
    }

    public int hashCode() {
        return ((this.pqd.hashCode() + 527) * 31) + this.pqe.hashCode();
    }

    public String toString() {
        return com.bytedance.sdk.a.b.a.c.a("%s: %s", this.pqd.a(), this.pqe.a());
    }
}
