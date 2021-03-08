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
    static final c[] psk = {new c(c.psh, ""), new c(c.pse, "GET"), new c(c.pse, "POST"), new c(c.psf, "/"), new c(c.psf, "/index.html"), new c(c.psg, HttpHost.DEFAULT_SCHEME_NAME), new c(c.psg, "https"), new c(c.b, BasicPushStatus.SUCCESS_CODE), new c(c.b, "204"), new c(c.b, "206"), new c(c.b, "304"), new c(c.b, "400"), new c(c.b, "404"), new c(c.b, "500"), new c("accept-charset", ""), new c("accept-encoding", "gzip, deflate"), new c("accept-language", ""), new c(Headers.ACCEPT_RANGES, ""), new c(UbcStatConstant.ContentType.UBC_TYPE_PK_ACCPET, ""), new c("access-control-allow-origin", ""), new c("age", ""), new c("allow", ""), new c("authorization", ""), new c(Headers.CACHE_CONTROL, ""), new c(Headers.CONTENT_DISPOSITION, ""), new c(Headers.CONTENT_ENCODING, ""), new c("content-language", ""), new c(Headers.CONTENT_LEN, ""), new c("content-location", ""), new c("content-range", ""), new c(Headers.CONTENT_TYPE, ""), new c("cookie", ""), new c("date", ""), new c("etag", ""), new c("expect", ""), new c("expires", ""), new c("from", ""), new c("host", ""), new c("if-match", ""), new c("if-modified-since", ""), new c("if-none-match", ""), new c("if-range", ""), new c("if-unmodified-since", ""), new c(Headers.LAST_MODIFIED, ""), new c("link", ""), new c(Headers.LOCATION, ""), new c("max-forwards", ""), new c(Headers.PROXY_AUTHENTICATE, ""), new c("proxy-authorization", ""), new c("range", ""), new c(Config.LAUNCH_REFERER, ""), new c(Headers.REFRESH, ""), new c("retry-after", ""), new c("server", ""), new c(Headers.SET_COOKIE, ""), new c("strict-transport-security", ""), new c(Headers.TRANSFER_ENCODING, ""), new c("user-agent", ""), new c("vary", ""), new c("via", ""), new c(Headers.WWW_AUTHENTICATE, "")};
    static final Map<com.bytedance.sdk.a.a.f, Integer> b = a();

    /* loaded from: classes6.dex */
    static final class a {
        int b;
        int c;
        int d;
        private final List<c> e;
        private final int g;
        private int h;
        c[] psk;
        private final com.bytedance.sdk.a.a.e psl;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(int i, s sVar) {
            this(i, i, sVar);
        }

        a(int i, int i2, s sVar) {
            this.e = new ArrayList();
            this.psk = new c[8];
            this.b = this.psk.length - 1;
            this.c = 0;
            this.d = 0;
            this.g = i;
            this.h = i2;
            this.psl = com.bytedance.sdk.a.a.l.c(sVar);
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
            Arrays.fill(this.psk, (Object) null);
            this.b = this.psk.length - 1;
            this.c = 0;
            this.d = 0;
        }

        private int a(int i) {
            int i2 = 0;
            if (i > 0) {
                int length = this.psk.length;
                while (true) {
                    length--;
                    if (length < this.b || i <= 0) {
                        break;
                    }
                    i -= this.psk[length].i;
                    this.d -= this.psk[length].i;
                    this.c--;
                    i2++;
                }
                System.arraycopy(this.psk, this.b + 1, this.psk, this.b + 1 + i2, this.c);
                this.b += i2;
            }
            return i2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a() throws IOException {
            while (!this.psl.e()) {
                int eoJ = this.psl.eoJ() & 255;
                if (eoJ == 128) {
                    throw new IOException("index == 0");
                }
                if ((eoJ & 128) == 128) {
                    b(a(eoJ, ThunderNetStateService.NetState.SYSNET_UNKNOWN) - 1);
                } else if (eoJ == 64) {
                    g();
                } else if ((eoJ & 64) == 64) {
                    e(a(eoJ, 63) - 1);
                } else if ((eoJ & 32) == 32) {
                    this.h = a(eoJ, 31);
                    if (this.h < 0 || this.h > this.g) {
                        throw new IOException("Invalid dynamic table size update " + this.h);
                    }
                    d();
                } else if (eoJ == 16 || eoJ == 0) {
                    f();
                } else {
                    d(a(eoJ, 15) - 1);
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
                this.e.add(d.psk[i]);
                return;
            }
            int c = c(i - d.psk.length);
            if (c < 0 || c > this.psk.length - 1) {
                throw new IOException("Header index too large " + (i + 1));
            }
            this.e.add(this.psk[c]);
        }

        private int c(int i) {
            return this.b + 1 + i;
        }

        private void d(int i) throws IOException {
            this.e.add(new c(OC(i), c()));
        }

        private void f() throws IOException {
            this.e.add(new c(d.d(c()), c()));
        }

        private void e(int i) throws IOException {
            a(-1, new c(OC(i), c()));
        }

        private void g() throws IOException {
            a(-1, new c(d.d(c()), c()));
        }

        private com.bytedance.sdk.a.a.f OC(int i) {
            return g(i) ? d.psk[i].psi : this.psk[c(i - d.psk.length)].psi;
        }

        private boolean g(int i) {
            return i >= 0 && i <= d.psk.length + (-1);
        }

        private void a(int i, c cVar) {
            this.e.add(cVar);
            int i2 = cVar.i;
            if (i != -1) {
                i2 -= this.psk[c(i)].i;
            }
            if (i2 > this.h) {
                e();
                return;
            }
            int a2 = a((this.d + i2) - this.h);
            if (i == -1) {
                if (this.c + 1 > this.psk.length) {
                    c[] cVarArr = new c[this.psk.length * 2];
                    System.arraycopy(this.psk, 0, cVarArr, this.psk.length, this.psk.length);
                    this.b = this.psk.length - 1;
                    this.psk = cVarArr;
                }
                int i3 = this.b;
                this.b = i3 - 1;
                this.psk[i3] = cVar;
                this.c++;
            } else {
                this.psk[a2 + c(i) + i] = cVar;
            }
            this.d = i2 + this.d;
        }

        private int h() throws IOException {
            return this.psl.eoJ() & 255;
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
                return com.bytedance.sdk.a.a.f.a(k.epK().a(this.psl.ik(a2)));
            }
            return this.psl.ii(a2);
        }
    }

    private static Map<com.bytedance.sdk.a.a.f, Integer> a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(psk.length);
        for (int i = 0; i < psk.length; i++) {
            if (!linkedHashMap.containsKey(psk[i].psi)) {
                linkedHashMap.put(psk[i].psi, Integer.valueOf(i));
            }
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    /* loaded from: classes6.dex */
    static final class b {

        /* renamed from: a  reason: collision with root package name */
        int f3968a;
        int b;
        int d;
        int e;
        int f;
        private final boolean h;
        private int i;
        private boolean j;
        private final com.bytedance.sdk.a.a.c psm;
        c[] psn;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(com.bytedance.sdk.a.a.c cVar) {
            this(4096, true, cVar);
        }

        b(int i, boolean z, com.bytedance.sdk.a.a.c cVar) {
            this.i = Integer.MAX_VALUE;
            this.psn = new c[8];
            this.d = this.psn.length - 1;
            this.e = 0;
            this.f = 0;
            this.f3968a = i;
            this.b = i;
            this.h = z;
            this.psm = cVar;
        }

        private void a() {
            Arrays.fill(this.psn, (Object) null);
            this.d = this.psn.length - 1;
            this.e = 0;
            this.f = 0;
        }

        private int b(int i) {
            int i2 = 0;
            if (i > 0) {
                int length = this.psn.length;
                while (true) {
                    length--;
                    if (length < this.d || i <= 0) {
                        break;
                    }
                    i -= this.psn[length].i;
                    this.f -= this.psn[length].i;
                    this.e--;
                    i2++;
                }
                System.arraycopy(this.psn, this.d + 1, this.psn, this.d + 1 + i2, this.e);
                Arrays.fill(this.psn, this.d + 1, this.d + 1 + i2, (Object) null);
                this.d += i2;
            }
            return i2;
        }

        private void a(c cVar) {
            int i = cVar.i;
            if (i > this.b) {
                a();
                return;
            }
            b((this.f + i) - this.b);
            if (this.e + 1 > this.psn.length) {
                c[] cVarArr = new c[this.psn.length * 2];
                System.arraycopy(this.psn, 0, cVarArr, this.psn.length, this.psn.length);
                this.d = this.psn.length - 1;
                this.psn = cVarArr;
            }
            int i2 = this.d;
            this.d = i2 - 1;
            this.psn[i2] = cVar;
            this.e++;
            this.f = i + this.f;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(List<c> list) throws IOException {
            int i;
            int i2;
            if (this.j) {
                if (this.i < this.b) {
                    a(this.i, 31, 32);
                }
                this.j = false;
                this.i = Integer.MAX_VALUE;
                a(this.b, 31, 32);
            }
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                c cVar = list.get(i3);
                com.bytedance.sdk.a.a.f f = cVar.psi.f();
                com.bytedance.sdk.a.a.f fVar = cVar.psj;
                Integer num = d.b.get(f);
                if (num != null) {
                    int intValue = num.intValue() + 1;
                    if (intValue > 1 && intValue < 8) {
                        if (com.bytedance.sdk.a.b.a.c.a(d.psk[intValue - 1].psj, fVar)) {
                            i = intValue;
                            i2 = intValue;
                        } else if (com.bytedance.sdk.a.b.a.c.a(d.psk[intValue].psj, fVar)) {
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
                    int length = this.psn.length;
                    while (true) {
                        if (i4 >= length) {
                            break;
                        }
                        if (com.bytedance.sdk.a.b.a.c.a(this.psn[i4].psi, f)) {
                            if (com.bytedance.sdk.a.b.a.c.a(this.psn[i4].psj, fVar)) {
                                i2 = (i4 - this.d) + d.psk.length;
                                break;
                            } else if (i == -1) {
                                i = (i4 - this.d) + d.psk.length;
                            }
                        }
                        i4++;
                    }
                }
                if (i2 != -1) {
                    a(i2, ThunderNetStateService.NetState.SYSNET_UNKNOWN, 128);
                } else if (i == -1) {
                    this.psm.OF(64);
                    e(f);
                    e(fVar);
                    a(cVar);
                } else if (f.a(c.psd) && !c.psh.equals(f)) {
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
                this.psm.OF(i3 | i);
                return;
            }
            this.psm.OF(i3 | i2);
            int i4 = i - i2;
            while (i4 >= 128) {
                this.psm.OF((i4 & ThunderNetStateService.NetState.SYSNET_UNKNOWN) | 128);
                i4 >>>= 7;
            }
            this.psm.OF(i4);
        }

        void e(com.bytedance.sdk.a.a.f fVar) throws IOException {
            if (this.h && k.epK().f(fVar) < fVar.g()) {
                com.bytedance.sdk.a.a.c cVar = new com.bytedance.sdk.a.a.c();
                k.epK().a(fVar, cVar);
                com.bytedance.sdk.a.a.f eoM = cVar.eoM();
                a(eoM.g(), ThunderNetStateService.NetState.SYSNET_UNKNOWN, 128);
                this.psm.c(eoM);
                return;
            }
            a(fVar.g(), ThunderNetStateService.NetState.SYSNET_UNKNOWN, 0);
            this.psm.c(fVar);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(int i) {
            this.f3968a = i;
            int min = Math.min(i, 16384);
            if (this.b != min) {
                if (min < this.b) {
                    this.i = Math.min(this.i, min);
                }
                this.j = true;
                this.b = min;
                b();
            }
        }

        private void b() {
            if (this.b < this.f) {
                if (this.b == 0) {
                    a();
                } else {
                    b(this.f - this.b);
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
