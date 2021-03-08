package com.bytedance.embedapplog;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;
/* loaded from: classes6.dex */
public class ce {
    private static long f;
    private static a pqe;

    /* renamed from: a  reason: collision with root package name */
    String f3927a;
    private long g;
    private int h;
    private long i = -1;
    private volatile boolean j;
    private long k;
    private int l;
    private String m;
    private final m ppQ;
    private final cn ppR;
    private aj pqb;
    private aj pqc;
    private ah pqd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(m mVar, cn cnVar) {
        this.ppQ = mVar;
        this.ppR = cnVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized ah eoq() {
        return this.pqd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Bundle P(long j, long j2) {
        Bundle bundle;
        bundle = null;
        if (this.ppR.f() && c() && j - this.g > j2) {
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
        long j = acVar instanceof a ? -1L : acVar.f3899a;
        this.f3927a = UUID.randomUUID().toString();
        f = this.ppR.eoA();
        this.i = j;
        this.j = z;
        this.k = 0L;
        if (au.b) {
            au.a("startSession, " + this.f3927a + ", hadUi:" + z + " data:" + acVar, null);
        }
        if (z) {
            Calendar calendar = Calendar.getInstance();
            String str = "" + calendar.get(1) + calendar.get(2) + calendar.get(5);
            if (TextUtils.isEmpty(this.m)) {
                this.m = this.ppR.c();
                this.l = this.ppR.d();
            }
            if (!str.equals(this.m)) {
                this.m = str;
                this.l = 1;
            } else {
                this.l++;
            }
            this.ppR.a(str, this.l);
            this.h = 0;
        }
        if (j != -1) {
            ah ahVar = new ah();
            ahVar.c = this.f3927a;
            ahVar.b = a(this.ppR);
            ahVar.f3899a = this.i;
            ahVar.i = this.ppQ.d();
            ahVar.h = this.ppQ.c();
            if (this.ppR.v()) {
                ahVar.e = b.enH();
                ahVar.f = b.enF();
            }
            arrayList.add(ahVar);
            this.pqd = ahVar;
            if (au.b) {
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
        boolean b = b(acVar);
        if (this.i == -1) {
            a(acVar, arrayList, b(acVar));
            z = true;
        } else if (!this.j && b) {
            a(acVar, arrayList, true);
            z = true;
        } else if (this.k != 0 && acVar.f3899a > this.k + this.ppR.eoy()) {
            a(acVar, arrayList, b);
            z = true;
        } else if (this.i > acVar.f3899a + 7200000) {
            a(acVar, arrayList, b);
            z = true;
        } else {
            z = false;
        }
        if (z2) {
            aj ajVar = (aj) acVar;
            if (ajVar.i()) {
                this.g = acVar.f3899a;
                this.k = 0L;
                arrayList.add(acVar);
                if (TextUtils.isEmpty(ajVar.i)) {
                    if (this.pqc != null && (ajVar.f3899a - this.pqc.f3899a) - this.pqc.h < 500) {
                        ajVar.i = this.pqc.j;
                    } else if (this.pqb != null && (ajVar.f3899a - this.pqb.f3899a) - this.pqb.h < 500) {
                        ajVar.i = this.pqb.j;
                    }
                }
            } else {
                Bundle P = P(acVar.f3899a, 0L);
                if (P != null) {
                    b.k("play_session", P);
                }
                this.g = 0L;
                this.k = ajVar.f3899a;
                arrayList.add(acVar);
                if (ajVar.j()) {
                    this.pqb = ajVar;
                } else {
                    this.pqc = ajVar;
                    this.pqb = null;
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
            acVar.d = this.ppQ.f();
            acVar.c = this.f3927a;
            acVar.b = a(this.ppR);
            if (this.ppR.v()) {
                acVar.e = b.enH();
                acVar.f = b.enF();
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
    public static a eor() {
        if (pqe == null) {
            pqe = new a();
        }
        pqe.f3899a = System.currentTimeMillis();
        return pqe;
    }
}
