package com.bytedance.sdk.a.b.a.a;

import com.baidubce.http.Headers;
import com.bytedance.sdk.a.b.ab;
import com.bytedance.sdk.a.b.b;
import com.bytedance.sdk.a.b.g;
import com.bytedance.sdk.a.b.v;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.http.StatusLine;
/* loaded from: classes4.dex */
public final class c {
    public final ab pdR;
    public final com.bytedance.sdk.a.b.b pdS;

    c(ab abVar, com.bytedance.sdk.a.b.b bVar) {
        this.pdR = abVar;
        this.pdS = bVar;
    }

    public static boolean a(com.bytedance.sdk.a.b.b bVar, ab abVar) {
        switch (bVar.c()) {
            case 200:
            case 203:
            case 204:
            case 300:
            case 301:
            case StatusLine.HTTP_PERM_REDIRECT /* 308 */:
            case 404:
            case 405:
            case 410:
            case 414:
            case 501:
                break;
            default:
                return false;
            case 302:
            case 307:
                if (bVar.a(Headers.EXPIRES) == null && bVar.enp().c() == -1 && !bVar.enp().e() && !bVar.enp().d()) {
                    return false;
                }
                break;
        }
        return (bVar.enp().b() || abVar.eoe().b()) ? false : true;
    }

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final long f5855a;
        private Date d;
        private String e;
        private String g;
        private long i;
        private long j;
        private String k;
        private int l;
        final ab pdT;
        final com.bytedance.sdk.a.b.b pdU;
        private Date pdV;
        private Date pdW;

        public a(long j, ab abVar, com.bytedance.sdk.a.b.b bVar) {
            this.l = -1;
            this.f5855a = j;
            this.pdT = abVar;
            this.pdU = bVar;
            if (bVar != null) {
                this.i = bVar.k();
                this.j = bVar.l();
                v enl = bVar.enl();
                int a2 = enl.a();
                for (int i = 0; i < a2; i++) {
                    String a3 = enl.a(i);
                    String b2 = enl.b(i);
                    if ("Date".equalsIgnoreCase(a3)) {
                        this.d = com.bytedance.sdk.a.b.a.c.d.a(b2);
                        this.e = b2;
                    } else if (Headers.EXPIRES.equalsIgnoreCase(a3)) {
                        this.pdW = com.bytedance.sdk.a.b.a.c.d.a(b2);
                    } else if (Headers.LAST_MODIFIED.equalsIgnoreCase(a3)) {
                        this.pdV = com.bytedance.sdk.a.b.a.c.d.a(b2);
                        this.g = b2;
                    } else if (Headers.ETAG.equalsIgnoreCase(a3)) {
                        this.k = b2;
                    } else if ("Age".equalsIgnoreCase(a3)) {
                        this.l = com.bytedance.sdk.a.b.a.c.e.b(b2, -1);
                    }
                }
            }
        }

        public c emz() {
            c emA = emA();
            if (emA.pdR != null && this.pdT.eoe().i()) {
                return new c(null, null);
            }
            return emA;
        }

        private c emA() {
            String str;
            String str2;
            long j = 0;
            if (this.pdU == null) {
                return new c(this.pdT, null);
            }
            if (this.pdT.g() && this.pdU.enk() == null) {
                return new c(this.pdT, null);
            }
            if (!c.a(this.pdU, this.pdT)) {
                return new c(this.pdT, null);
            }
            g eoe = this.pdT.eoe();
            if (eoe.a() || a(this.pdT)) {
                return new c(this.pdT, null);
            }
            g enp = this.pdU.enp();
            if (enp.j()) {
                return new c(null, this.pdU);
            }
            long d = d();
            long c = c();
            if (eoe.c() != -1) {
                c = Math.min(c, TimeUnit.SECONDS.toMillis(eoe.c()));
            }
            long millis = eoe.h() != -1 ? TimeUnit.SECONDS.toMillis(eoe.h()) : 0L;
            if (!enp.f() && eoe.g() != -1) {
                j = TimeUnit.SECONDS.toMillis(eoe.g());
            }
            if (!enp.a() && d + millis < j + c) {
                b.a enn = this.pdU.enn();
                if (millis + d >= c) {
                    enn.hb("Warning", "110 HttpURLConnection \"Response is stale\"");
                }
                if (d > 86400000 && e()) {
                    enn.hb("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                }
                return new c(null, enn.enq());
            }
            if (this.k != null) {
                str = "If-None-Match";
                str2 = this.k;
            } else if (this.pdV != null) {
                str = "If-Modified-Since";
                str2 = this.g;
            } else if (this.d != null) {
                str = "If-Modified-Since";
                str2 = this.e;
            } else {
                return new c(this.pdT, null);
            }
            v.a enB = this.pdT.emV().enB();
            com.bytedance.sdk.a.b.a.a.pdM.a(enB, str, str2);
            return new c(this.pdT.eod().e(enB.enC()).eoj(), this.pdU);
        }

        private long c() {
            g enp;
            if (this.pdU.enp().c() != -1) {
                return TimeUnit.SECONDS.toMillis(enp.c());
            }
            if (this.pdW != null) {
                long time = this.pdW.getTime() - (this.d != null ? this.d.getTime() : this.j);
                if (time <= 0) {
                    time = 0;
                }
                return time;
            } else if (this.pdV == null || this.pdU.emS().emp().k() != null) {
                return 0L;
            } else {
                long time2 = (this.d != null ? this.d.getTime() : this.i) - this.pdV.getTime();
                if (time2 > 0) {
                    return time2 / 10;
                }
                return 0L;
            }
        }

        private long d() {
            long max = this.d != null ? Math.max(0L, this.j - this.d.getTime()) : 0L;
            if (this.l != -1) {
                max = Math.max(max, TimeUnit.SECONDS.toMillis(this.l));
            }
            return max + (this.j - this.i) + (this.f5855a - this.j);
        }

        private boolean e() {
            return this.pdU.enp().c() == -1 && this.pdW == null;
        }

        private static boolean a(ab abVar) {
            return (abVar.a("If-Modified-Since") == null && abVar.a("If-None-Match") == null) ? false : true;
        }
    }
}
