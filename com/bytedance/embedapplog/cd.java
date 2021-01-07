package com.bytedance.embedapplog;

import android.content.Context;
import com.kwad.sdk.collector.AppStatusRules;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class cd extends bv {
    private static final long[] phA = {AppStatusRules.DEFAULT_GRANULARITY};
    private long f;
    private long g;
    private final cn pgH;
    private final m phC;
    private final ad phE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(Context context, ad adVar, cn cnVar, m mVar) {
        super(context);
        this.phE = adVar;
        this.pgH = cnVar;
        this.phC = mVar;
    }

    @Override // com.bytedance.embedapplog.bv
    boolean a() {
        return true;
    }

    @Override // com.bytedance.embedapplog.bv
    long b() {
        long j = AppStatusRules.DEFAULT_GRANULARITY;
        long epM = this.pgH.epM();
        if (epM <= AppStatusRules.DEFAULT_GRANULARITY && epM > 0) {
            j = epM;
        }
        phA[0] = j;
        return j + this.f;
    }

    @Override // com.bytedance.embedapplog.bv
    long[] epx() {
        return phA;
    }

    @Override // com.bytedance.embedapplog.bv
    public boolean d() {
        ah epA;
        if (System.currentTimeMillis() > this.g + this.pgH.epM()) {
            JSONObject b2 = this.phC.b();
            ce epz = bx.epz();
            if (epz != null && b2 != null && (epA = epz.epA()) != null) {
                this.phE.a(b2, epA, epz.b());
                this.g = System.currentTimeMillis();
            }
        }
        ArrayList<ai> a2 = this.phE.a();
        ArrayList<ai> arrayList = new ArrayList<>(a2.size());
        ArrayList<ai> arrayList2 = new ArrayList<>(a2.size());
        this.phE.a(this.f6114a, this.phC.a());
        this.phE.a(this.f6114a);
        String[] m = ab.m(this.f6114a, this.phC.a());
        Iterator<ai> it = a2.iterator();
        while (it.hasNext()) {
            ai next = it.next();
            int a3 = aa.a(m, next.h, this.pgH);
            if (a3 == 200) {
                arrayList.add(next);
            } else {
                next.j = a3;
                arrayList2.add(next);
            }
        }
        if (arrayList.size() > 0 || arrayList2.size() > 0) {
            this.phE.j(arrayList, arrayList2);
        }
        au.d(e() + arrayList.size() + " " + a2.size(), null);
        if (arrayList.size() == a2.size()) {
            this.f = System.currentTimeMillis();
            return true;
        }
        return false;
    }

    @Override // com.bytedance.embedapplog.bv
    String e() {
        return "s";
    }
}
