package com.bytedance.sdk.a.b;

import com.baidubce.http.Headers;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.concurrent.TimeUnit;
import org.apache.http.cookie.ClientCookie;
/* loaded from: classes6.dex */
public final class g {
    public static final g prB = new a().epW().epY();
    public static final g prC = new a().epX().a(Integer.MAX_VALUE, TimeUnit.SECONDS).epY();
    String c;
    private final boolean d;
    private final boolean e;
    private final int f;
    private final int g;
    private final boolean h;
    private final boolean i;
    private final boolean j;
    private final int k;
    private final int l;
    private final boolean m;
    private final boolean n;
    private final boolean o;

    private g(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, boolean z8, String str) {
        this.d = z;
        this.e = z2;
        this.f = i;
        this.g = i2;
        this.h = z3;
        this.i = z4;
        this.j = z5;
        this.k = i3;
        this.l = i4;
        this.m = z6;
        this.n = z7;
        this.o = z8;
        this.c = str;
    }

    g(a aVar) {
        this.d = aVar.f5959a;
        this.e = aVar.f5960b;
        this.f = aVar.c;
        this.g = -1;
        this.h = false;
        this.i = false;
        this.j = false;
        this.k = aVar.d;
        this.l = aVar.e;
        this.m = aVar.f;
        this.n = aVar.g;
        this.o = aVar.h;
    }

    public boolean a() {
        return this.d;
    }

    public boolean b() {
        return this.e;
    }

    public int c() {
        return this.f;
    }

    public boolean d() {
        return this.h;
    }

    public boolean e() {
        return this.i;
    }

    public boolean f() {
        return this.j;
    }

    public int g() {
        return this.k;
    }

    public int h() {
        return this.l;
    }

    public boolean i() {
        return this.m;
    }

    public boolean j() {
        return this.o;
    }

    public static g d(v vVar) {
        boolean z;
        int i;
        String str;
        boolean z2 = false;
        boolean z3 = false;
        int i2 = -1;
        int i3 = -1;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        int i4 = -1;
        int i5 = -1;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        boolean z10 = true;
        String str2 = null;
        int a2 = vVar.a();
        int i6 = 0;
        while (i6 < a2) {
            String a3 = vVar.a(i6);
            String b2 = vVar.b(i6);
            if (a3.equalsIgnoreCase(Headers.CACHE_CONTROL)) {
                if (str2 != null) {
                    z10 = false;
                } else {
                    str2 = b2;
                }
            } else if (!a3.equalsIgnoreCase("Pragma")) {
                z = z2;
                i6++;
                z2 = z;
            } else {
                z10 = false;
            }
            z = z2;
            for (int i7 = 0; i7 < b2.length(); i7 = i) {
                int y = com.bytedance.sdk.a.b.a.c.e.y(b2, i7, "=,;");
                String trim = b2.substring(i7, y).trim();
                if (y == b2.length() || b2.charAt(y) == ',' || b2.charAt(y) == ';') {
                    i = y + 1;
                    str = null;
                } else {
                    int a4 = com.bytedance.sdk.a.b.a.c.e.a(b2, y + 1);
                    if (a4 < b2.length() && b2.charAt(a4) == '\"') {
                        int i8 = a4 + 1;
                        int y2 = com.bytedance.sdk.a.b.a.c.e.y(b2, i8, "\"");
                        str = b2.substring(i8, y2);
                        i = y2 + 1;
                    } else {
                        i = com.bytedance.sdk.a.b.a.c.e.y(b2, a4, ",;");
                        str = b2.substring(a4, i).trim();
                    }
                }
                if ("no-cache".equalsIgnoreCase(trim)) {
                    z = true;
                } else if ("no-store".equalsIgnoreCase(trim)) {
                    z3 = true;
                } else if (ClientCookie.MAX_AGE_ATTR.equalsIgnoreCase(trim)) {
                    i2 = com.bytedance.sdk.a.b.a.c.e.b(str, -1);
                } else if ("s-maxage".equalsIgnoreCase(trim)) {
                    i3 = com.bytedance.sdk.a.b.a.c.e.b(str, -1);
                } else if (PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE.equalsIgnoreCase(trim)) {
                    z4 = true;
                } else if ("public".equalsIgnoreCase(trim)) {
                    z5 = true;
                } else if ("must-revalidate".equalsIgnoreCase(trim)) {
                    z6 = true;
                } else if ("max-stale".equalsIgnoreCase(trim)) {
                    i4 = com.bytedance.sdk.a.b.a.c.e.b(str, Integer.MAX_VALUE);
                } else if ("min-fresh".equalsIgnoreCase(trim)) {
                    i5 = com.bytedance.sdk.a.b.a.c.e.b(str, -1);
                } else if ("only-if-cached".equalsIgnoreCase(trim)) {
                    z7 = true;
                } else if ("no-transform".equalsIgnoreCase(trim)) {
                    z8 = true;
                } else if ("immutable".equalsIgnoreCase(trim)) {
                    z9 = true;
                }
            }
            i6++;
            z2 = z;
        }
        return new g(z2, z3, i2, i3, z4, z5, z6, i4, i5, z7, z8, z9, !z10 ? null : str2);
    }

    public String toString() {
        String str = this.c;
        if (str != null) {
            return str;
        }
        String k = k();
        this.c = k;
        return k;
    }

    private String k() {
        StringBuilder sb = new StringBuilder();
        if (this.d) {
            sb.append("no-cache, ");
        }
        if (this.e) {
            sb.append("no-store, ");
        }
        if (this.f != -1) {
            sb.append("max-age=").append(this.f).append(", ");
        }
        if (this.g != -1) {
            sb.append("s-maxage=").append(this.g).append(", ");
        }
        if (this.h) {
            sb.append("private, ");
        }
        if (this.i) {
            sb.append("public, ");
        }
        if (this.j) {
            sb.append("must-revalidate, ");
        }
        if (this.k != -1) {
            sb.append("max-stale=").append(this.k).append(", ");
        }
        if (this.l != -1) {
            sb.append("min-fresh=").append(this.l).append(", ");
        }
        if (this.m) {
            sb.append("only-if-cached, ");
        }
        if (this.n) {
            sb.append("no-transform, ");
        }
        if (this.o) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        boolean f5959a;

        /* renamed from: b  reason: collision with root package name */
        boolean f5960b;
        int c = -1;
        int d = -1;
        int e = -1;
        boolean f;
        boolean g;
        boolean h;

        public a epW() {
            this.f5959a = true;
            return this;
        }

        public a a(int i, TimeUnit timeUnit) {
            if (i < 0) {
                throw new IllegalArgumentException("maxStale < 0: " + i);
            }
            long seconds = timeUnit.toSeconds(i);
            this.d = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
            return this;
        }

        public a epX() {
            this.f = true;
            return this;
        }

        public g epY() {
            return new g(this);
        }
    }
}
