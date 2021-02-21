package com.bytedance.embedapplog;

import android.content.Context;
import com.kwad.sdk.collector.AppStatusRules;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class cd extends bv {
    private static final long[] pnM = {AppStatusRules.DEFAULT_GRANULARITY};
    private long f;
    private long g;
    private final cn pmU;
    private final m pnO;
    private final ad pnQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(Context context, ad adVar, cn cnVar, m mVar) {
        super(context);
        this.pnQ = adVar;
        this.pmU = cnVar;
        this.pnO = mVar;
    }

    @Override // com.bytedance.embedapplog.bv
    boolean a() {
        return true;
    }

    @Override // com.bytedance.embedapplog.bv
    long b() {
        long j = AppStatusRules.DEFAULT_GRANULARITY;
        long eos = this.pmU.eos();
        if (eos <= AppStatusRules.DEFAULT_GRANULARITY && eos > 0) {
            j = eos;
        }
        pnM[0] = j;
        return j + this.f;
    }

    @Override // com.bytedance.embedapplog.bv
    long[] eoc() {
        return pnM;
    }

    @Override // com.bytedance.embedapplog.bv
    public boolean d() {
        ah eog;
        if (System.currentTimeMillis() > this.g + this.pmU.eos()) {
            JSONObject b2 = this.pnO.b();
            ce eoe = bx.eoe();
            if (eoe != null && b2 != null && (eog = eoe.eog()) != null) {
                this.pnQ.a(b2, eog, eoe.b());
                this.g = System.currentTimeMillis();
            }
        }
        ArrayList<ai> a2 = this.pnQ.a();
        ArrayList<ai> arrayList = new ArrayList<>(a2.size());
        ArrayList<ai> arrayList2 = new ArrayList<>(a2.size());
        this.pnQ.a(this.f5816a, this.pnO.a());
        this.pnQ.a(this.f5816a);
        String[] m = ab.m(this.f5816a, this.pnO.a());
        Iterator<ai> it = a2.iterator();
        while (it.hasNext()) {
            ai next = it.next();
            int a3 = aa.a(m, next.h, this.pmU);
            if (a3 == 200) {
                arrayList.add(next);
            } else {
                next.j = a3;
                arrayList2.add(next);
            }
        }
        if (arrayList.size() > 0 || arrayList2.size() > 0) {
            this.pnQ.j(arrayList, arrayList2);
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
