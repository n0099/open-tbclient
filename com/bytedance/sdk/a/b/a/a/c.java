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
                if (bVar.a(Headers.EXPIRES) == null && bVar.erk().c() == -1 && !bVar.erk().e() && !bVar.erk().d()) {
                    return false;
                }
                break;
        }
        return (bVar.erk().b() || abVar.erZ().b()) ? false : true;
    }

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final long f6155a;
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
            this.f6155a = j;
            this.piy = abVar;
            this.piz = bVar;
            if (bVar != null) {
                this.i = bVar.k();
                this.j = bVar.l();
                v erg = bVar.erg();
                int a2 = erg.a();
                for (int i = 0; i < a2; i++) {
                    String a3 = erg.a(i);
                    String b2 = erg.b(i);
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

        public c eqv() {
            c eqw = eqw();
            if (eqw.piw != null && this.piy.erZ().i()) {
                return new c(null, null);
            }
            return eqw;
        }

        private c eqw() {
            String str;
            String str2;
            long j = 0;
            if (this.piz == null) {
                return new c(this.piy, null);
            }
            if (this.piy.g() && this.piz.erf() == null) {
                return new c(this.piy, null);
            }
            if (!c.a(this.piz, this.piy)) {
                return new c(this.piy, null);
            }
            g erZ = this.piy.erZ();
            if (erZ.a() || a(this.piy)) {
                return new c(this.piy, null);
            }
            g erk = this.piz.erk();
            if (erk.j()) {
                return new c(null, this.piz);
            }
            long d = d();
            long c = c();
            if (erZ.c() != -1) {
                c = Math.min(c, TimeUnit.SECONDS.toMillis(erZ.c()));
            }
            long millis = erZ.h() != -1 ? TimeUnit.SECONDS.toMillis(erZ.h()) : 0L;
            if (!erk.f() && erZ.g() != -1) {
                j = TimeUnit.SECONDS.toMillis(erZ.g());
            }
            if (!erk.a() && d + millis < j + c) {
                b.a eri = this.piz.eri();
                if (millis + d >= c) {
                    eri.hc("Warning", "110 HttpURLConnection \"Response is stale\"");
                }
                if (d > 86400000 && e()) {
                    eri.hc("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                }
                return new c(null, eri.erl());
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
            v.a erx = this.piy.eqR().erx();
            com.bytedance.sdk.a.b.a.a.pir.a(erx, str, str2);
            return new c(this.piy.erY().e(erx.ery()).esd(), this.piz);
        }

        private long c() {
            g erk;
            if (this.piz.erk().c() != -1) {
                return TimeUnit.SECONDS.toMillis(erk.c());
            }
            if (this.piB != null) {
                long time = this.piB.getTime() - (this.d != null ? this.d.getTime() : this.j);
                if (time <= 0) {
                    time = 0;
                }
                return time;
            } else if (this.piA == null || this.piz.eqO().eql().k() != null) {
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
            return max + (this.j - this.i) + (this.f6155a - this.j);
        }

        private boolean e() {
            return this.piz.erk().c() == -1 && this.piB == null;
        }

        private static boolean a(ab abVar) {
            return (abVar.a("If-Modified-Since") == null && abVar.a("If-None-Match") == null) ? false : true;
        }
    }
}
