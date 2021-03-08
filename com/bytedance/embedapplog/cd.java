package com.bytedance.embedapplog;

import android.content.Context;
import com.kwad.sdk.collector.AppStatusRules;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class cd extends bv {
    private static final long[] ppW = {AppStatusRules.DEFAULT_GRANULARITY};
    private long f;
    private long g;
    private final m ppY;
    private final cn ppc;
    private final ad pqa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(Context context, ad adVar, cn cnVar, m mVar) {
        super(context);
        this.pqa = adVar;
        this.ppc = cnVar;
        this.ppY = mVar;
    }

    @Override // com.bytedance.embedapplog.bv
    boolean a() {
        return true;
    }

    @Override // com.bytedance.embedapplog.bv
    long b() {
        long j = AppStatusRules.DEFAULT_GRANULARITY;
        long eoz = this.ppc.eoz();
        if (eoz <= AppStatusRules.DEFAULT_GRANULARITY && eoz > 0) {
            j = eoz;
        }
        ppW[0] = j;
        return j + this.f;
    }

    @Override // com.bytedance.embedapplog.bv
    long[] eon() {
        return ppW;
    }

    @Override // com.bytedance.embedapplog.bv
    public boolean d() {
        ah eoq;
        if (System.currentTimeMillis() > this.g + this.ppc.eoz()) {
            JSONObject b = this.ppY.b();
            ce eop = bx.eop();
            if (eop != null && b != null && (eoq = eop.eoq()) != null) {
                this.pqa.a(b, eoq, eop.b());
                this.g = System.currentTimeMillis();
            }
        }
        ArrayList<ai> a2 = this.pqa.a();
        ArrayList<ai> arrayList = new ArrayList<>(a2.size());
        ArrayList<ai> arrayList2 = new ArrayList<>(a2.size());
        String[] m = ab.m(this.f3924a, this.ppY.a());
        Iterator<ai> it = a2.iterator();
        while (it.hasNext()) {
            ai next = it.next();
            int a3 = aa.a(m, next.h, this.ppc);
            if (a3 == 200) {
                arrayList.add(next);
            } else {
                next.j = a3;
                arrayList2.add(next);
            }
        }
        if (arrayList.size() > 0 || arrayList2.size() > 0) {
            this.pqa.j(arrayList, arrayList2);
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
