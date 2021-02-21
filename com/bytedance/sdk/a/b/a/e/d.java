package com.bytedance.sdk.a.b.a.e;

import android.net.http.Headers;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.mobstat.Config;
import com.bytedance.sdk.a.a.s;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.thunder.livesdk.system.ThunderNetStateService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpHost;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class d {
    static final c[] pqf = {new c(c.pqc, ""), new c(c.ppZ, "GET"), new c(c.ppZ, "POST"), new c(c.pqa, "/"), new c(c.pqa, "/index.html"), new c(c.pqb, HttpHost.DEFAULT_SCHEME_NAME), new c(c.pqb, "https"), new c(c.f5892b, BasicPushStatus.SUCCESS_CODE), new c(c.f5892b, "204"), new c(c.f5892b, "206"), new c(c.f5892b, "304"), new c(c.f5892b, "400"), new c(c.f5892b, "404"), new c(c.f5892b, "500"), new c("accept-charset", ""), new c("accept-encoding", "gzip, deflate"), new c("accept-language", ""), new c(Headers.ACCEPT_RANGES, ""), new c(UbcStatConstant.ContentType.UBC_TYPE_PK_ACCPET, ""), new c("access-control-allow-origin", ""), new c("age", ""), new c("allow", ""), new c("authorization", ""), new c(Headers.CACHE_CONTROL, ""), new c(Headers.CONTENT_DISPOSITION, ""), new c(Headers.CONTENT_ENCODING, ""), new c("content-language", ""), new c(Headers.CONTENT_LEN, ""), new c("content-location", ""), new c("content-range", ""), new c(Headers.CONTENT_TYPE, ""), new c("cookie", ""), new c("date", ""), new c("etag", ""), new c("expect", ""), new c("expires", ""), new c("from", ""), new c("host", ""), new c("if-match", ""), new c("if-modified-since", ""), new c("if-none-match", ""), new c("if-range", ""), new c("if-unmodified-since", ""), new c(Headers.LAST_MODIFIED, ""), new c("link", ""), new c(Headers.LOCATION, ""), new c("max-forwards", ""), new c(Headers.PROXY_AUTHENTICATE, ""), new c("proxy-authorization", ""), new c("range", ""), new c(Config.LAUNCH_REFERER, ""), new c(Headers.REFRESH, ""), new c("retry-after", ""), new c("server", ""), new c(Headers.SET_COOKIE, ""), new c("strict-transport-security", ""), new c(Headers.TRANSFER_ENCODING, ""), new c("user-agent", ""), new c("vary", ""), new c("via", ""), new c(Headers.WWW_AUTHENTICATE, "")};

    /* renamed from: b  reason: collision with root package name */
    static final Map<com.bytedance.sdk.a.a.f, Integer> f5893b = a();

    /* loaded from: classes6.dex */
    static final class a {

        /* renamed from: b  reason: collision with root package name */
        int f5894b;
        int c;
        int d;
        private final List<c> e;
        private final int g;
        private int h;
        c[] pqf;
        private final com.bytedance.sdk.a.a.e pqg;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(int i, s sVar) {
            this(i, i, sVar);
        }

        a(int i, int i2, s sVar) {
            this.e = new ArrayList();
            this.pqf = new c[8];
            this.f5894b = this.pqf.length - 1;
            this.c = 0;
            this.d = 0;
            this.g = i;
            this.h = i2;
            this.pqg = com.bytedance.sdk.a.a.l.c(sVar);
        }

        private void d() {
            if (this.h < this.d) {
                if (this.h == 0) {
                    e();
                } else {
                    a(this.d - this.h);
                }
            }
        }

        private void e() {
            Arrays.fill(this.pqf, (Object) null);
            this.f5894b = this.pqf.length - 1;
            this.c = 0;
            this.d = 0;
        }

        private int a(int i) {
            int i2 = 0;
            if (i > 0) {
                int length = this.pqf.length;
                while (true) {
                    length--;
                    if (length < this.f5894b || i <= 0) {
                        break;
                    }
                    i -= this.pqf[length].i;
                    this.d -= this.pqf[length].i;
                    this.c--;
                    i2++;
                }
                System.arraycopy(this.pqf, this.f5894b + 1, this.pqf, this.f5894b + 1 + i2, this.c);
                this.f5894b += i2;
            }
            return i2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a() throws IOException {
            while (!this.pqg.e()) {
                int eoC = this.pqg.eoC() & 255;
                if (eoC == 128) {
                    throw new IOException("index == 0");
                }
                if ((eoC & 128) == 128) {
                    b(a(eoC, ThunderNetStateService.NetState.SYSNET_UNKNOWN) - 1);
                } else if (eoC == 64) {
                    g();
                } else if ((eoC & 64) == 64) {
                    e(a(eoC, 63) - 1);
                } else if ((eoC & 32) == 32) {
                    this.h = a(eoC, 31);
                    if (this.h < 0 || this.h > this.g) {
                        throw new IOException("Invalid dynamic table size update " + this.h);
                    }
                    d();
                } else if (eoC == 16 || eoC == 0) {
                    f();
                } else {
                    d(a(eoC, 15) - 1);
                }
            }
        }

        public List<c> b() {
            ArrayList arrayList = new ArrayList(this.e);
            this.e.clear();
            return arrayList;
        }

        private void b(int i) throws IOException {
            if (g(i)) {
                this.e.add(d.pqf[i]);
                return;
            }
            int c = c(i - d.pqf.length);
            if (c < 0 || c > this.pqf.length - 1) {
                throw new IOException("Header index too large " + (i + 1));
            }
            this.e.add(this.pqf[c]);
        }

        private int c(int i) {
            return this.f5894b + 1 + i;
        }

        private void d(int i) throws IOException {
            this.e.add(new c(Oy(i), c()));
        }

        private void f() throws IOException {
            this.e.add(new c(d.d(c()), c()));
        }

        private void e(int i) throws IOException {
            a(-1, new c(Oy(i), c()));
        }

        private void g() throws IOException {
            a(-1, new c(d.d(c()), c()));
        }

        private com.bytedance.sdk.a.a.f Oy(int i) {
            return g(i) ? d.pqf[i].pqd : this.pqf[c(i - d.pqf.length)].pqd;
        }

        private boolean g(int i) {
            return i >= 0 && i <= d.pqf.length + (-1);
        }

        private void a(int i, c cVar) {
            this.e.add(cVar);
            int i2 = cVar.i;
            if (i != -1) {
                i2 -= this.pqf[c(i)].i;
            }
            if (i2 > this.h) {
                e();
                return;
            }
            int a2 = a((this.d + i2) - this.h);
            if (i == -1) {
                if (this.c + 1 > this.pqf.length) {
                    c[] cVarArr = new c[this.pqf.length * 2];
                    System.arraycopy(this.pqf, 0, cVarArr, this.pqf.length, this.pqf.length);
                    this.f5894b = this.pqf.length - 1;
                    this.pqf = cVarArr;
                }
                int i3 = this.f5894b;
                this.f5894b = i3 - 1;
                this.pqf[i3] = cVar;
                this.c++;
            } else {
                this.pqf[a2 + c(i) + i] = cVar;
            }
            this.d = i2 + this.d;
        }

        private int h() throws IOException {
            return this.pqg.eoC() & 255;
        }

        int a(int i, int i2) throws IOException {
            int i3 = i & i2;
            if (i3 >= i2) {
                int i4 = 0;
                while (true) {
                    int h = h();
                    if ((h & 128) != 0) {
                        i2 += (h & ThunderNetStateService.NetState.SYSNET_UNKNOWN) << i4;
                        i4 += 7;
                    } else {
                        return (h << i4) + i2;
                    }
                }
            } else {
                return i3;
            }
        }

        com.bytedance.sdk.a.a.f c() throws IOException {
            int h = h();
            boolean z = (h & 128) == 128;
            int a2 = a(h, ThunderNetStateService.NetState.SYSNET_UNKNOWN);
            if (z) {
                return com.bytedance.sdk.a.a.f.a(k.epD().a(this.pqg.ik(a2)));
            }
            return this.pqg.ii(a2);
        }
    }

    private static Map<com.bytedance.sdk.a.a.f, Integer> a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(pqf.length);
        for (int i = 0; i < pqf.length; i++) {
            if (!linkedHashMap.containsKey(pqf[i].pqd)) {
                linkedHashMap.put(pqf[i].pqd, Integer.valueOf(i));
            }
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    /* loaded from: classes6.dex */
    static final class b {

        /* renamed from: a  reason: collision with root package name */
        int f5895a;

        /* renamed from: b  reason: collision with root package name */
        int f5896b;
        int d;
        int e;
        int f;
        private final boolean h;
        private int i;
        private boolean j;
        private final com.bytedance.sdk.a.a.c pqh;
        c[] pqi;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(com.bytedance.sdk.a.a.c cVar) {
            this(4096, true, cVar);
        }

        b(int i, boolean z, com.bytedance.sdk.a.a.c cVar) {
            this.i = Integer.MAX_VALUE;
            this.pqi = new c[8];
            this.d = this.pqi.length - 1;
            this.e = 0;
            this.f = 0;
            this.f5895a = i;
            this.f5896b = i;
            this.h = z;
            this.pqh = cVar;
        }

        private void a() {
            Arrays.fill(this.pqi, (Object) null);
            this.d = this.pqi.length - 1;
            this.e = 0;
            this.f = 0;
        }

        private int b(int i) {
            int i2 = 0;
            if (i > 0) {
                int length = this.pqi.length;
                while (true) {
                    length--;
                    if (length < this.d || i <= 0) {
                        break;
                    }
                    i -= this.pqi[length].i;
                    this.f -= this.pqi[length].i;
                    this.e--;
                    i2++;
                }
                System.arraycopy(this.pqi, this.d + 1, this.pqi, this.d + 1 + i2, this.e);
                Arrays.fill(this.pqi, this.d + 1, this.d + 1 + i2, (Object) null);
                this.d += i2;
            }
            return i2;
        }

        private void a(c cVar) {
            int i = cVar.i;
            if (i > this.f5896b) {
                a();
                return;
            }
            b((this.f + i) - this.f5896b);
            if (this.e + 1 > this.pqi.length) {
                c[] cVarArr = new c[this.pqi.length * 2];
                System.arraycopy(this.pqi, 0, cVarArr, this.pqi.length, this.pqi.length);
                this.d = this.pqi.length - 1;
                this.pqi = cVarArr;
            }
            int i2 = this.d;
            this.d = i2 - 1;
            this.pqi[i2] = cVar;
            this.e++;
            this.f = i + this.f;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(List<c> list) throws IOException {
            int i;
            int i2;
            if (this.j) {
                if (this.i < this.f5896b) {
                    a(this.i, 31, 32);
                }
                this.j = false;
                this.i = Integer.MAX_VALUE;
                a(this.f5896b, 31, 32);
            }
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                c cVar = list.get(i3);
                com.bytedance.sdk.a.a.f f = cVar.pqd.f();
                com.bytedance.sdk.a.a.f fVar = cVar.pqe;
                Integer num = d.f5893b.get(f);
                if (num != null) {
                    int intValue = num.intValue() + 1;
                    if (intValue > 1 && intValue < 8) {
                        if (com.bytedance.sdk.a.b.a.c.a(d.pqf[intValue - 1].pqe, fVar)) {
                            i = intValue;
                            i2 = intValue;
                        } else if (com.bytedance.sdk.a.b.a.c.a(d.pqf[intValue].pqe, fVar)) {
                            i2 = intValue + 1;
                            i = intValue;
                        }
                    }
                    i = intValue;
                    i2 = -1;
                } else {
                    i = -1;
                    i2 = -1;
                }
                if (i2 == -1) {
                    int i4 = this.d + 1;
                    int length = this.pqi.length;
                    while (true) {
                        if (i4 >= length) {
                            break;
                        }
                        if (com.bytedance.sdk.a.b.a.c.a(this.pqi[i4].pqd, f)) {
                            if (com.bytedance.sdk.a.b.a.c.a(this.pqi[i4].pqe, fVar)) {
                                i2 = (i4 - this.d) + d.pqf.length;
                                break;
                            } else if (i == -1) {
                                i = (i4 - this.d) + d.pqf.length;
                            }
                        }
                        i4++;
                    }
                }
                if (i2 != -1) {
                    a(i2, ThunderNetStateService.NetState.SYSNET_UNKNOWN, 128);
                } else if (i == -1) {
                    this.pqh.OB(64);
                    e(f);
                    e(fVar);
                    a(cVar);
                } else if (f.a(c.ppY) && !c.pqc.equals(f)) {
                    a(i, 15, 0);
                    e(fVar);
                } else {
                    a(i, 63, 64);
                    e(fVar);
                    a(cVar);
                }
            }
        }

        void a(int i, int i2, int i3) {
            if (i < i2) {
                this.pqh.OB(i3 | i);
                return;
            }
            this.pqh.OB(i3 | i2);
            int i4 = i - i2;
            while (i4 >= 128) {
                this.pqh.OB((i4 & ThunderNetStateService.NetState.SYSNET_UNKNOWN) | 128);
                i4 >>>= 7;
            }
            this.pqh.OB(i4);
        }

        void e(com.bytedance.sdk.a.a.f fVar) throws IOException {
            if (this.h && k.epD().f(fVar) < fVar.g()) {
                com.bytedance.sdk.a.a.c cVar = new com.bytedance.sdk.a.a.c();
                k.epD().a(fVar, cVar);
                com.bytedance.sdk.a.a.f eoF = cVar.eoF();
                a(eoF.g(), ThunderNetStateService.NetState.SYSNET_UNKNOWN, 128);
                this.pqh.c(eoF);
                return;
            }
            a(fVar.g(), ThunderNetStateService.NetState.SYSNET_UNKNOWN, 0);
            this.pqh.c(fVar);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(int i) {
            this.f5895a = i;
            int min = Math.min(i, 16384);
            if (this.f5896b != min) {
                if (min < this.f5896b) {
                    this.i = Math.min(this.i, min);
                }
                this.j = true;
                this.f5896b = min;
                b();
            }
        }

        private void b() {
            if (this.f5896b < this.f) {
                if (this.f5896b == 0) {
                    a();
                } else {
                    b(this.f - this.f5896b);
                }
            }
        }
    }

    static com.bytedance.sdk.a.a.f d(com.bytedance.sdk.a.a.f fVar) throws IOException {
        int g = fVar.g();
        for (int i = 0; i < g; i++) {
            byte a2 = fVar.a(i);
            if (a2 >= 65 && a2 <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + fVar.a());
            }
        }
        return fVar;
    }
}
