package com.bytedance.embedapplog;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;
/* loaded from: classes6.dex */
public class ce {
    private static long f;
    private static a pnu;

    /* renamed from: a  reason: collision with root package name */
    String f5822a;
    private long g;
    private int h;
    private long i = -1;
    private volatile boolean j;
    private long k;
    private int l;
    private String m;
    private final m png;
    private final cn pnh;
    private aj pnr;
    private aj pns;
    private ah pnt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(m mVar, cn cnVar) {
        this.png = mVar;
        this.pnh = cnVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized ah enX() {
        return this.pnt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Bundle P(long j, long j2) {
        Bundle bundle;
        bundle = null;
        if (this.pnh.f() && c() && j - this.g > j2) {
            bundle = new Bundle();
            bundle.putInt("session_no", this.l);
            int i = this.h + 1;
            this.h = i;
            bundle.putInt("send_times", i);
            bundle.putLong("current_duration", (j - this.g) / 1000);
            bundle.putString("session_start_time", ac.a(this.i));
            this.g = j;
        }
        return bundle;
    }

    public boolean b() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        return b() && this.k == 0;
    }

    private synchronized void a(ac acVar, ArrayList<ac> arrayList, boolean z) {
        long j = acVar instanceof a ? -1L : acVar.f5776a;
        this.f5822a = UUID.randomUUID().toString();
        f = this.pnh.eol();
        this.i = j;
        this.j = z;
        this.k = 0L;
        if (au.f5788b) {
            au.a("startSession, " + this.f5822a + ", hadUi:" + z + " data:" + acVar, null);
        }
        if (z) {
            Calendar calendar = Calendar.getInstance();
            String str = "" + calendar.get(1) + calendar.get(2) + calendar.get(5);
            if (TextUtils.isEmpty(this.m)) {
                this.m = this.pnh.c();
                this.l = this.pnh.d();
            }
            if (!str.equals(this.m)) {
                this.m = str;
                this.l = 1;
            } else {
                this.l++;
            }
            this.pnh.a(str, this.l);
            this.h = 0;
        }
        if (j != -1) {
            ah ahVar = new ah();
            ahVar.c = this.f5822a;
            ahVar.f5777b = a(this.pnh);
            ahVar.f5776a = this.i;
            ahVar.i = this.png.d();
            ahVar.h = this.png.c();
            if (this.pnh.v()) {
                ahVar.e = b.enp();
                ahVar.f = b.enn();
            }
            arrayList.add(ahVar);
            this.pnt = ahVar;
            if (au.f5788b) {
                au.a("gen launch, " + ahVar.c + ", hadUi:" + z, null);
            }
        }
    }

    public static boolean b(ac acVar) {
        if (acVar instanceof aj) {
            return ((aj) acVar).i();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(ac acVar, ArrayList<ac> arrayList) {
        boolean z;
        boolean z2 = acVar instanceof aj;
        boolean b2 = b(acVar);
        if (this.i == -1) {
            a(acVar, arrayList, b(acVar));
            z = true;
        } else if (!this.j && b2) {
            a(acVar, arrayList, true);
            z = true;
        } else if (this.k != 0 && acVar.f5776a > this.k + this.pnh.eoj()) {
            a(acVar, arrayList, b2);
            z = true;
        } else if (this.i > acVar.f5776a + 7200000) {
            a(acVar, arrayList, b2);
            z = true;
        } else {
            z = false;
        }
        if (z2) {
            aj ajVar = (aj) acVar;
            if (ajVar.i()) {
                this.g = acVar.f5776a;
                this.k = 0L;
                arrayList.add(acVar);
                if (TextUtils.isEmpty(ajVar.i)) {
                    if (this.pns != null && (ajVar.f5776a - this.pns.f5776a) - this.pns.h < 500) {
                        ajVar.i = this.pns.j;
                    } else if (this.pnr != null && (ajVar.f5776a - this.pnr.f5776a) - this.pnr.h < 500) {
                        ajVar.i = this.pnr.j;
                    }
                }
            } else {
                Bundle P = P(acVar.f5776a, 0L);
                if (P != null) {
                    b.k("play_session", P);
                }
                this.g = 0L;
                this.k = ajVar.f5776a;
                arrayList.add(acVar);
                if (ajVar.j()) {
                    this.pnr = ajVar;
                } else {
                    this.pns = ajVar;
                    this.pnr = null;
                }
            }
        } else if (!(acVar instanceof a)) {
            arrayList.add(acVar);
        }
        c(acVar);
        return z;
    }

    public void c(ac acVar) {
        if (acVar != null) {
            acVar.d = this.png.f();
            acVar.c = this.f5822a;
            acVar.f5777b = a(this.pnh);
            if (this.pnh.v()) {
                acVar.e = b.enp();
                acVar.f = b.enn();
            }
        }
    }

    public static long a(cn cnVar) {
        f++;
        if (f % 1000 == 0) {
            cnVar.a(f + 1000);
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a extends am {
        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a enY() {
        if (pnu == null) {
            pnu = new a();
        }
        pnu.f5776a = System.currentTimeMillis();
        return pnu;
    }
}
