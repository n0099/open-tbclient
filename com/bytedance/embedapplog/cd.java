package com.bytedance.embedapplog;

import android.content.Context;
import com.kwad.sdk.collector.AppStatusRules;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class cd extends bv {
    private static final long[] pnm = {AppStatusRules.DEFAULT_GRANULARITY};
    private long f;
    private long g;
    private final cn pmu;
    private final m pno;
    private final ad pnq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(Context context, ad adVar, cn cnVar, m mVar) {
        super(context);
        this.pnq = adVar;
        this.pmu = cnVar;
        this.pno = mVar;
    }

    @Override // com.bytedance.embedapplog.bv
    boolean a() {
        return true;
    }

    @Override // com.bytedance.embedapplog.bv
    long b() {
        long j = AppStatusRules.DEFAULT_GRANULARITY;
        long eok = this.pmu.eok();
        if (eok <= AppStatusRules.DEFAULT_GRANULARITY && eok > 0) {
            j = eok;
        }
        pnm[0] = j;
        return j + this.f;
    }

    @Override // com.bytedance.embedapplog.bv
    long[] enU() {
        return pnm;
    }

    @Override // com.bytedance.embedapplog.bv
    public boolean d() {
        ah enX;
        if (System.currentTimeMillis() > this.g + this.pmu.eok()) {
            JSONObject b2 = this.pno.b();
            ce enW = bx.enW();
            if (enW != null && b2 != null && (enX = enW.enX()) != null) {
                this.pnq.a(b2, enX, enW.b());
                this.g = System.currentTimeMillis();
            }
        }
        ArrayList<ai> a2 = this.pnq.a();
        ArrayList<ai> arrayList = new ArrayList<>(a2.size());
        ArrayList<ai> arrayList2 = new ArrayList<>(a2.size());
        this.pnq.a(this.f5816a, this.pno.a());
        this.pnq.a(this.f5816a);
        String[] m = ab.m(this.f5816a, this.pno.a());
        Iterator<ai> it = a2.iterator();
        while (it.hasNext()) {
            ai next = it.next();
            int a3 = aa.a(m, next.h, this.pmu);
            if (a3 == 200) {
                arrayList.add(next);
            } else {
                next.j = a3;
                arrayList2.add(next);
            }
        }
        if (arrayList.size() > 0 || arrayList2.size() > 0) {
            this.pnq.j(arrayList, arrayList2);
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
