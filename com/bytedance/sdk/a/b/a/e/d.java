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
    static final c[] ppF = {new c(c.ppC, ""), new c(c.ppz, "GET"), new c(c.ppz, "POST"), new c(c.ppA, "/"), new c(c.ppA, "/index.html"), new c(c.ppB, HttpHost.DEFAULT_SCHEME_NAME), new c(c.ppB, "https"), new c(c.f5892b, BasicPushStatus.SUCCESS_CODE), new c(c.f5892b, "204"), new c(c.f5892b, "206"), new c(c.f5892b, "304"), new c(c.f5892b, "400"), new c(c.f5892b, "404"), new c(c.f5892b, "500"), new c("accept-charset", ""), new c("accept-encoding", "gzip, deflate"), new c("accept-language", ""), new c(Headers.ACCEPT_RANGES, ""), new c(UbcStatConstant.ContentType.UBC_TYPE_PK_ACCPET, ""), new c("access-control-allow-origin", ""), new c("age", ""), new c("allow", ""), new c("authorization", ""), new c(Headers.CACHE_CONTROL, ""), new c(Headers.CONTENT_DISPOSITION, ""), new c(Headers.CONTENT_ENCODING, ""), new c("content-language", ""), new c(Headers.CONTENT_LEN, ""), new c("content-location", ""), new c("content-range", ""), new c(Headers.CONTENT_TYPE, ""), new c("cookie", ""), new c("date", ""), new c("etag", ""), new c("expect", ""), new c("expires", ""), new c("from", ""), new c("host", ""), new c("if-match", ""), new c("if-modified-since", ""), new c("if-none-match", ""), new c("if-range", ""), new c("if-unmodified-since", ""), new c(Headers.LAST_MODIFIED, ""), new c("link", ""), new c(Headers.LOCATION, ""), new c("max-forwards", ""), new c(Headers.PROXY_AUTHENTICATE, ""), new c("proxy-authorization", ""), new c("range", ""), new c(Config.LAUNCH_REFERER, ""), new c(Headers.REFRESH, ""), new c("retry-after", ""), new c("server", ""), new c(Headers.SET_COOKIE, ""), new c("strict-transport-security", ""), new c(Headers.TRANSFER_ENCODING, ""), new c("user-agent", ""), new c("vary", ""), new c("via", ""), new c(Headers.WWW_AUTHENTICATE, "")};

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
        c[] ppF;
        private final com.bytedance.sdk.a.a.e ppG;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(int i, s sVar) {
            this(i, i, sVar);
        }

        a(int i, int i2, s sVar) {
            this.e = new ArrayList();
            this.ppF = new c[8];
            this.f5894b = this.ppF.length - 1;
            this.c = 0;
            this.d = 0;
            this.g = i;
            this.h = i2;
            this.ppG = com.bytedance.sdk.a.a.l.c(sVar);
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
            Arrays.fill(this.ppF, (Object) null);
            this.f5894b = this.ppF.length - 1;
            this.c = 0;
            this.d = 0;
        }

        private int a(int i) {
            int i2 = 0;
            if (i > 0) {
                int length = this.ppF.length;
                while (true) {
                    length--;
                    if (length < this.f5894b || i <= 0) {
                        break;
                    }
                    i -= this.ppF[length].i;
                    this.d -= this.ppF[length].i;
                    this.c--;
                    i2++;
                }
                System.arraycopy(this.ppF, this.f5894b + 1, this.ppF, this.f5894b + 1 + i2, this.c);
                this.f5894b += i2;
            }
            return i2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a() throws IOException {
            while (!this.ppG.e()) {
                int eou = this.ppG.eou() & 255;
                if (eou == 128) {
                    throw new IOException("index == 0");
                }
                if ((eou & 128) == 128) {
                    b(a(eou, ThunderNetStateService.NetState.SYSNET_UNKNOWN) - 1);
                } else if (eou == 64) {
                    g();
                } else if ((eou & 64) == 64) {
                    e(a(eou, 63) - 1);
                } else if ((eou & 32) == 32) {
                    this.h = a(eou, 31);
                    if (this.h < 0 || this.h > this.g) {
                        throw new IOException("Invalid dynamic table size update " + this.h);
                    }
                    d();
                } else if (eou == 16 || eou == 0) {
                    f();
                } else {
                    d(a(eou, 15) - 1);
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
                this.e.add(d.ppF[i]);
                return;
            }
            int c = c(i - d.ppF.length);
            if (c < 0 || c > this.ppF.length - 1) {
                throw new IOException("Header index too large " + (i + 1));
            }
            this.e.add(this.ppF[c]);
        }

        private int c(int i) {
            return this.f5894b + 1 + i;
        }

        private void d(int i) throws IOException {
            this.e.add(new c(Ox(i), c()));
        }

        private void f() throws IOException {
            this.e.add(new c(d.d(c()), c()));
        }

        private void e(int i) throws IOException {
            a(-1, new c(Ox(i), c()));
        }

        private void g() throws IOException {
            a(-1, new c(d.d(c()), c()));
        }

        private com.bytedance.sdk.a.a.f Ox(int i) {
            return g(i) ? d.ppF[i].ppD : this.ppF[c(i - d.ppF.length)].ppD;
        }

        private boolean g(int i) {
            return i >= 0 && i <= d.ppF.length + (-1);
        }

        private void a(int i, c cVar) {
            this.e.add(cVar);
            int i2 = cVar.i;
            if (i != -1) {
                i2 -= this.ppF[c(i)].i;
            }
            if (i2 > this.h) {
                e();
                return;
            }
            int a2 = a((this.d + i2) - this.h);
            if (i == -1) {
                if (this.c + 1 > this.ppF.length) {
                    c[] cVarArr = new c[this.ppF.length * 2];
                    System.arraycopy(this.ppF, 0, cVarArr, this.ppF.length, this.ppF.length);
                    this.f5894b = this.ppF.length - 1;
                    this.ppF = cVarArr;
                }
                int i3 = this.f5894b;
                this.f5894b = i3 - 1;
                this.ppF[i3] = cVar;
                this.c++;
            } else {
                this.ppF[a2 + c(i) + i] = cVar;
            }
            this.d = i2 + this.d;
        }

        private int h() throws IOException {
            return this.ppG.eou() & 255;
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
                return com.bytedance.sdk.a.a.f.a(k.epv().a(this.ppG.ik(a2)));
            }
            return this.ppG.ii(a2);
        }
    }

    private static Map<com.bytedance.sdk.a.a.f, Integer> a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(ppF.length);
        for (int i = 0; i < ppF.length; i++) {
            if (!linkedHashMap.containsKey(ppF[i].ppD)) {
                linkedHashMap.put(ppF[i].ppD, Integer.valueOf(i));
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
        private final com.bytedance.sdk.a.a.c ppH;
        c[] ppI;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(com.bytedance.sdk.a.a.c cVar) {
            this(4096, true, cVar);
        }

        b(int i, boolean z, com.bytedance.sdk.a.a.c cVar) {
            this.i = Integer.MAX_VALUE;
            this.ppI = new c[8];
            this.d = this.ppI.length - 1;
            this.e = 0;
            this.f = 0;
            this.f5895a = i;
            this.f5896b = i;
            this.h = z;
            this.ppH = cVar;
        }

        private void a() {
            Arrays.fill(this.ppI, (Object) null);
            this.d = this.ppI.length - 1;
            this.e = 0;
            this.f = 0;
        }

        private int b(int i) {
            int i2 = 0;
            if (i > 0) {
                int length = this.ppI.length;
                while (true) {
                    length--;
                    if (length < this.d || i <= 0) {
                        break;
                    }
                    i -= this.ppI[length].i;
                    this.f -= this.ppI[length].i;
                    this.e--;
                    i2++;
                }
                System.arraycopy(this.ppI, this.d + 1, this.ppI, this.d + 1 + i2, this.e);
                Arrays.fill(this.ppI, this.d + 1, this.d + 1 + i2, (Object) null);
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
            if (this.e + 1 > this.ppI.length) {
                c[] cVarArr = new c[this.ppI.length * 2];
                System.arraycopy(this.ppI, 0, cVarArr, this.ppI.length, this.ppI.length);
                this.d = this.ppI.length - 1;
                this.ppI = cVarArr;
            }
            int i2 = this.d;
            this.d = i2 - 1;
            this.ppI[i2] = cVar;
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
                com.bytedance.sdk.a.a.f f = cVar.ppD.f();
                com.bytedance.sdk.a.a.f fVar = cVar.ppE;
                Integer num = d.f5893b.get(f);
                if (num != null) {
                    int intValue = num.intValue() + 1;
                    if (intValue > 1 && intValue < 8) {
                        if (com.bytedance.sdk.a.b.a.c.a(d.ppF[intValue - 1].ppE, fVar)) {
                            i = intValue;
                            i2 = intValue;
                        } else if (com.bytedance.sdk.a.b.a.c.a(d.ppF[intValue].ppE, fVar)) {
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
                    int length = this.ppI.length;
                    while (true) {
                        if (i4 >= length) {
                            break;
                        }
                        if (com.bytedance.sdk.a.b.a.c.a(this.ppI[i4].ppD, f)) {
                            if (com.bytedance.sdk.a.b.a.c.a(this.ppI[i4].ppE, fVar)) {
                                i2 = (i4 - this.d) + d.ppF.length;
                                break;
                            } else if (i == -1) {
                                i = (i4 - this.d) + d.ppF.length;
                            }
                        }
                        i4++;
                    }
                }
                if (i2 != -1) {
                    a(i2, ThunderNetStateService.NetState.SYSNET_UNKNOWN, 128);
                } else if (i == -1) {
                    this.ppH.OA(64);
                    e(f);
                    e(fVar);
                    a(cVar);
                } else if (f.a(c.ppy) && !c.ppC.equals(f)) {
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
                this.ppH.OA(i3 | i);
                return;
            }
            this.ppH.OA(i3 | i2);
            int i4 = i - i2;
            while (i4 >= 128) {
                this.ppH.OA((i4 & ThunderNetStateService.NetState.SYSNET_UNKNOWN) | 128);
                i4 >>>= 7;
            }
            this.ppH.OA(i4);
        }

        void e(com.bytedance.sdk.a.a.f fVar) throws IOException {
            if (this.h && k.epv().f(fVar) < fVar.g()) {
                com.bytedance.sdk.a.a.c cVar = new com.bytedance.sdk.a.a.c();
                k.epv().a(fVar, cVar);
                com.bytedance.sdk.a.a.f eox = cVar.eox();
                a(eox.g(), ThunderNetStateService.NetState.SYSNET_UNKNOWN, 128);
                this.ppH.c(eox);
                return;
            }
            a(fVar.g(), ThunderNetStateService.NetState.SYSNET_UNKNOWN, 0);
            this.ppH.c(fVar);
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
