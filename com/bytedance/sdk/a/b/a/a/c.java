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
    public final ab piw;
    public final com.bytedance.sdk.a.b.b pix;

    c(ab abVar, com.bytedance.sdk.a.b.b bVar) {
        this.piw = abVar;
        this.pix = bVar;
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
                if (bVar.a(Headers.EXPIRES) == null && bVar.erj().c() == -1 && !bVar.erj().e() && !bVar.erj().d()) {
                    return false;
                }
                break;
        }
        return (bVar.erj().b() || abVar.erY().b()) ? false : true;
    }

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final long f6154a;
        private Date d;
        private String e;
        private String g;
        private long i;
        private long j;
        private String k;
        private int l;
        private Date piA;
        private Date piB;
        final ab piy;
        final com.bytedance.sdk.a.b.b piz;

        public a(long j, ab abVar, com.bytedance.sdk.a.b.b bVar) {
            this.l = -1;
            this.f6154a = j;
            this.piy = abVar;
            this.piz = bVar;
            if (bVar != null) {
                this.i = bVar.k();
                this.j = bVar.l();
                v erf = bVar.erf();
                int a2 = erf.a();
                for (int i = 0; i < a2; i++) {
                    String a3 = erf.a(i);
                    String b2 = erf.b(i);
                    if ("Date".equalsIgnoreCase(a3)) {
                        this.d = com.bytedance.sdk.a.b.a.c.d.a(b2);
                        this.e = b2;
                    } else if (Headers.EXPIRES.equalsIgnoreCase(a3)) {
                        this.piB = com.bytedance.sdk.a.b.a.c.d.a(b2);
                    } else if (Headers.LAST_MODIFIED.equalsIgnoreCase(a3)) {
                        this.piA = com.bytedance.sdk.a.b.a.c.d.a(b2);
                        this.g = b2;
                    } else if (Headers.ETAG.equalsIgnoreCase(a3)) {
                        this.k = b2;
                    } else if ("Age".equalsIgnoreCase(a3)) {
                        this.l = com.bytedance.sdk.a.b.a.c.e.b(b2, -1);
                    }
                }
            }
        }

        public c equ() {
            c eqv = eqv();
            if (eqv.piw != null && this.piy.erY().i()) {
                return new c(null, null);
            }
            return eqv;
        }

        private c eqv() {
            String str;
            String str2;
            long j = 0;
            if (this.piz == null) {
                return new c(this.piy, null);
            }
            if (this.piy.g() && this.piz.ere() == null) {
                return new c(this.piy, null);
            }
            if (!c.a(this.piz, this.piy)) {
                return new c(this.piy, null);
            }
            g erY = this.piy.erY();
            if (erY.a() || a(this.piy)) {
                return new c(this.piy, null);
            }
            g erj = this.piz.erj();
            if (erj.j()) {
                return new c(null, this.piz);
            }
            long d = d();
            long c = c();
            if (erY.c() != -1) {
                c = Math.min(c, TimeUnit.SECONDS.toMillis(erY.c()));
            }
            long millis = erY.h() != -1 ? TimeUnit.SECONDS.toMillis(erY.h()) : 0L;
            if (!erj.f() && erY.g() != -1) {
                j = TimeUnit.SECONDS.toMillis(erY.g());
            }
            if (!erj.a() && d + millis < j + c) {
                b.a erh = this.piz.erh();
                if (millis + d >= c) {
                    erh.hc("Warning", "110 HttpURLConnection \"Response is stale\"");
                }
                if (d > 86400000 && e()) {
                    erh.hc("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                }
                return new c(null, erh.erk());
            }
            if (this.k != null) {
                str = "If-None-Match";
                str2 = this.k;
            } else if (this.piA != null) {
                str = "If-Modified-Since";
                str2 = this.g;
            } else if (this.d != null) {
                str = "If-Modified-Since";
                str2 = this.e;
            } else {
                return new c(this.piy, null);
            }
            v.a erw = this.piy.eqQ().erw();
            com.bytedance.sdk.a.b.a.a.pir.a(erw, str, str2);
            return new c(this.piy.erX().e(erw.erx()).esc(), this.piz);
        }

        private long c() {
            g erj;
            if (this.piz.erj().c() != -1) {
                return TimeUnit.SECONDS.toMillis(erj.c());
            }
            if (this.piB != null) {
                long time = this.piB.getTime() - (this.d != null ? this.d.getTime() : this.j);
                if (time <= 0) {
                    time = 0;
                }
                return time;
            } else if (this.piA == null || this.piz.eqN().eqk().k() != null) {
                return 0L;
            } else {
                long time2 = (this.d != null ? this.d.getTime() : this.i) - this.piA.getTime();
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
            return max + (this.j - this.i) + (this.f6154a - this.j);
        }

        private boolean e() {
            return this.piz.erj().c() == -1 && this.piB == null;
        }

        private static boolean a(ab abVar) {
            return (abVar.a("If-Modified-Since") == null && abVar.a("If-None-Match") == null) ? false : true;
        }
    }
}
