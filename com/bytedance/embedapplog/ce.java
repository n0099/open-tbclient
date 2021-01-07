package com.bytedance.embedapplog;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;
/* loaded from: classes4.dex */
public class ce {
    private static long f;
    private static a phI;

    /* renamed from: a  reason: collision with root package name */
    String f6120a;
    private long g;
    private int h;
    private long i = -1;
    private volatile boolean j;
    private long k;
    private int l;
    private String m;
    private aj phF;
    private aj phG;
    private ah phH;
    private final m phu;
    private final cn phv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(m mVar, cn cnVar) {
        this.phu = mVar;
        this.phv = cnVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized ah epA() {
        return this.phH;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Bundle L(long j, long j2) {
        Bundle bundle;
        bundle = null;
        if (this.phv.f() && c() && j - this.g > j2) {
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
        long j = acVar instanceof a ? -1L : acVar.f6074a;
        this.f6120a = UUID.randomUUID().toString();
        f = this.phv.epN();
        this.i = j;
        this.j = z;
        this.k = 0L;
        if (au.f6086b) {
            au.a("startSession, " + this.f6120a + ", hadUi:" + z + " data:" + acVar, null);
        }
        if (z) {
            Calendar calendar = Calendar.getInstance();
            String str = "" + calendar.get(1) + calendar.get(2) + calendar.get(5);
            if (TextUtils.isEmpty(this.m)) {
                this.m = this.phv.c();
                this.l = this.phv.d();
            }
            if (!str.equals(this.m)) {
                this.m = str;
                this.l = 1;
            } else {
                this.l++;
            }
            this.phv.a(str, this.l);
            this.h = 0;
        }
        if (j != -1) {
            ah ahVar = new ah();
            ahVar.c = this.f6120a;
            ahVar.f6075b = a(this.phv);
            ahVar.f6074a = this.i;
            ahVar.i = this.phu.d();
            ahVar.h = this.phu.c();
            if (this.phv.v()) {
                ahVar.e = b.eoS();
                ahVar.f = b.eoQ();
            }
            arrayList.add(ahVar);
            this.phH = ahVar;
            if (au.f6086b) {
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
        } else if (this.k != 0 && acVar.f6074a > this.k + this.phv.epL()) {
            a(acVar, arrayList, b2);
            z = true;
        } else if (this.i > acVar.f6074a + 7200000) {
            a(acVar, arrayList, b2);
            z = true;
        } else {
            z = false;
        }
        if (z2) {
            aj ajVar = (aj) acVar;
            if (ajVar.i()) {
                this.g = acVar.f6074a;
                this.k = 0L;
                arrayList.add(acVar);
                if (TextUtils.isEmpty(ajVar.i)) {
                    if (this.phG != null && (ajVar.f6074a - this.phG.f6074a) - this.phG.h < 500) {
                        ajVar.i = this.phG.j;
                    } else if (this.phF != null && (ajVar.f6074a - this.phF.f6074a) - this.phF.h < 500) {
                        ajVar.i = this.phF.j;
                    }
                }
            } else {
                Bundle L = L(acVar.f6074a, 0L);
                if (L != null) {
                    b.j("play_session", L);
                }
                this.g = 0L;
                this.k = ajVar.f6074a;
                arrayList.add(acVar);
                if (ajVar.j()) {
                    this.phF = ajVar;
                } else {
                    this.phG = ajVar;
                    this.phF = null;
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
            acVar.d = this.phu.f();
            acVar.c = this.f6120a;
            acVar.f6075b = a(this.phv);
            if (this.phv.v()) {
                acVar.e = b.eoS();
                acVar.f = b.eoQ();
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
    public static a epB() {
        if (phI == null) {
            phI = new a();
        }
        phI.f6074a = System.currentTimeMillis();
        return phI;
    }
}
