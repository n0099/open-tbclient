package com.bytedance.embedapplog;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;
/* loaded from: classes6.dex */
public class ce {
    private static long f;
    private static a pnU;

    /* renamed from: a  reason: collision with root package name */
    String f5822a;
    private long g;
    private int h;
    private long i = -1;
    private volatile boolean j;
    private long k;
    private int l;
    private String m;
    private final m pnG;
    private final cn pnH;
    private aj pnR;
    private aj pnS;
    private ah pnT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(m mVar, cn cnVar) {
        this.pnG = mVar;
        this.pnH = cnVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized ah eog() {
        return this.pnT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Bundle P(long j, long j2) {
        Bundle bundle;
        bundle = null;
        if (this.pnH.f() && c() && j - this.g > j2) {
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
        f = this.pnH.eot();
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
                this.m = this.pnH.c();
                this.l = this.pnH.d();
            }
            if (!str.equals(this.m)) {
                this.m = str;
                this.l = 1;
            } else {
                this.l++;
            }
            this.pnH.a(str, this.l);
            this.h = 0;
        }
        if (j != -1) {
            ah ahVar = new ah();
            ahVar.c = this.f5822a;
            ahVar.f5777b = a(this.pnH);
            ahVar.f5776a = this.i;
            ahVar.i = this.pnG.d();
            ahVar.h = this.pnG.c();
            if (this.pnH.v()) {
                ahVar.e = b.enx();
                ahVar.f = b.env();
            }
            arrayList.add(ahVar);
            this.pnT = ahVar;
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
        } else if (this.k != 0 && acVar.f5776a > this.k + this.pnH.eor()) {
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
                    if (this.pnS != null && (ajVar.f5776a - this.pnS.f5776a) - this.pnS.h < 500) {
                        ajVar.i = this.pnS.j;
                    } else if (this.pnR != null && (ajVar.f5776a - this.pnR.f5776a) - this.pnR.h < 500) {
                        ajVar.i = this.pnR.j;
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
                    this.pnR = ajVar;
                } else {
                    this.pnS = ajVar;
                    this.pnR = null;
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
            acVar.d = this.pnG.f();
            acVar.c = this.f5822a;
            acVar.f5777b = a(this.pnH);
            if (this.pnH.v()) {
                acVar.e = b.enx();
                acVar.f = b.env();
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
    public static a eoh() {
        if (pnU == null) {
            pnU = new a();
        }
        pnU.f5776a = System.currentTimeMillis();
        return pnU;
    }
}
