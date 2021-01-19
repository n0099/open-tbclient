package com.bytedance.embedapplog;

import android.content.Context;
import com.kwad.sdk.collector.AppStatusRules;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class cd extends bv {
    private static final long[] pcZ = {AppStatusRules.DEFAULT_GRANULARITY};
    private long f;
    private long g;
    private final cn pcf;
    private final m pdb;
    private final ad pdd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(Context context, ad adVar, cn cnVar, m mVar) {
        super(context);
        this.pdd = adVar;
        this.pcf = cnVar;
        this.pdb = mVar;
    }

    @Override // com.bytedance.embedapplog.bv
    boolean a() {
        return true;
    }

    @Override // com.bytedance.embedapplog.bv
    long b() {
        long j = AppStatusRules.DEFAULT_GRANULARITY;
        long elQ = this.pcf.elQ();
        if (elQ <= AppStatusRules.DEFAULT_GRANULARITY && elQ > 0) {
            j = elQ;
        }
        pcZ[0] = j;
        return j + this.f;
    }

    @Override // com.bytedance.embedapplog.bv
    long[] elB() {
        return pcZ;
    }

    @Override // com.bytedance.embedapplog.bv
    public boolean d() {
        ah elE;
        if (System.currentTimeMillis() > this.g + this.pcf.elQ()) {
            JSONObject b2 = this.pdb.b();
            ce elD = bx.elD();
            if (elD != null && b2 != null && (elE = elD.elE()) != null) {
                this.pdd.a(b2, elE, elD.b());
                this.g = System.currentTimeMillis();
            }
        }
        ArrayList<ai> a2 = this.pdd.a();
        ArrayList<ai> arrayList = new ArrayList<>(a2.size());
        ArrayList<ai> arrayList2 = new ArrayList<>(a2.size());
        this.pdd.a(this.f5814a, this.pdb.a());
        this.pdd.a(this.f5814a);
        String[] m = ab.m(this.f5814a, this.pdb.a());
        Iterator<ai> it = a2.iterator();
        while (it.hasNext()) {
            ai next = it.next();
            int a3 = aa.a(m, next.h, this.pcf);
            if (a3 == 200) {
                arrayList.add(next);
            } else {
                next.j = a3;
                arrayList2.add(next);
            }
        }
        if (arrayList.size() > 0 || arrayList2.size() > 0) {
            this.pdd.j(arrayList, arrayList2);
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
