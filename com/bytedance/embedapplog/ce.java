package com.bytedance.embedapplog;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;
/* loaded from: classes4.dex */
public class ce {
    private static long f;
    private static a pdh;

    /* renamed from: a  reason: collision with root package name */
    String f5820a;
    private long g;
    private int h;
    private long i = -1;
    private volatile boolean j;
    private long k;
    private int l;
    private String m;
    private final m pcT;
    private final cn pcU;
    private aj pde;
    private aj pdf;
    private ah pdg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(m mVar, cn cnVar) {
        this.pcT = mVar;
        this.pcU = cnVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized ah elE() {
        return this.pdg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Bundle L(long j, long j2) {
        Bundle bundle;
        bundle = null;
        if (this.pcU.f() && c() && j - this.g > j2) {
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
        long j = acVar instanceof a ? -1L : acVar.f5774a;
        this.f5820a = UUID.randomUUID().toString();
        f = this.pcU.elR();
        this.i = j;
        this.j = z;
        this.k = 0L;
        if (au.f5786b) {
            au.a("startSession, " + this.f5820a + ", hadUi:" + z + " data:" + acVar, null);
        }
        if (z) {
            Calendar calendar = Calendar.getInstance();
            String str = "" + calendar.get(1) + calendar.get(2) + calendar.get(5);
            if (TextUtils.isEmpty(this.m)) {
                this.m = this.pcU.c();
                this.l = this.pcU.d();
            }
            if (!str.equals(this.m)) {
                this.m = str;
                this.l = 1;
            } else {
                this.l++;
            }
            this.pcU.a(str, this.l);
            this.h = 0;
        }
        if (j != -1) {
            ah ahVar = new ah();
            ahVar.c = this.f5820a;
            ahVar.f5775b = a(this.pcU);
            ahVar.f5774a = this.i;
            ahVar.i = this.pcT.d();
            ahVar.h = this.pcT.c();
            if (this.pcU.v()) {
                ahVar.e = b.ekW();
                ahVar.f = b.ekU();
            }
            arrayList.add(ahVar);
            this.pdg = ahVar;
            if (au.f5786b) {
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
        } else if (this.k != 0 && acVar.f5774a > this.k + this.pcU.elP()) {
            a(acVar, arrayList, b2);
            z = true;
        } else if (this.i > acVar.f5774a + 7200000) {
            a(acVar, arrayList, b2);
            z = true;
        } else {
            z = false;
        }
        if (z2) {
            aj ajVar = (aj) acVar;
            if (ajVar.i()) {
                this.g = acVar.f5774a;
                this.k = 0L;
                arrayList.add(acVar);
                if (TextUtils.isEmpty(ajVar.i)) {
                    if (this.pdf != null && (ajVar.f5774a - this.pdf.f5774a) - this.pdf.h < 500) {
                        ajVar.i = this.pdf.j;
                    } else if (this.pde != null && (ajVar.f5774a - this.pde.f5774a) - this.pde.h < 500) {
                        ajVar.i = this.pde.j;
                    }
                }
            } else {
                Bundle L = L(acVar.f5774a, 0L);
                if (L != null) {
                    b.k("play_session", L);
                }
                this.g = 0L;
                this.k = ajVar.f5774a;
                arrayList.add(acVar);
                if (ajVar.j()) {
                    this.pde = ajVar;
                } else {
                    this.pdf = ajVar;
                    this.pde = null;
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
            acVar.d = this.pcT.f();
            acVar.c = this.f5820a;
            acVar.f5775b = a(this.pcU);
            if (this.pcU.v()) {
                acVar.e = b.ekW();
                acVar.f = b.ekU();
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
    /* loaded from: classes4.dex */
    public static class a extends am {
        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a elF() {
        if (pdh == null) {
            pdh = new a();
        }
        pdh.f5774a = System.currentTimeMillis();
        return pdh;
    }
}
