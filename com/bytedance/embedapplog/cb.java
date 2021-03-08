package com.bytedance.embedapplog;

import android.content.Context;
import android.os.Bundle;
import com.kwad.sdk.collector.AppStatusRules;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class cb extends bv {
    private static final long[] ppW = {AppStatusRules.DEFAULT_GRANULARITY};
    private long e;
    private final m ppP;
    private final ad ppX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cb(Context context, m mVar, ad adVar) {
        super(context);
        this.ppX = adVar;
        this.ppP = mVar;
    }

    @Override // com.bytedance.embedapplog.bv
    boolean a() {
        return false;
    }

    @Override // com.bytedance.embedapplog.bv
    long b() {
        return this.e + AppStatusRules.DEFAULT_GRANULARITY;
    }

    @Override // com.bytedance.embedapplog.bv
    long[] eon() {
        return ppW;
    }

    @Override // com.bytedance.embedapplog.bv
    public boolean d() {
        Bundle P;
        long currentTimeMillis = System.currentTimeMillis();
        ce eop = bx.eop();
        if (eop != null && (P = eop.P(currentTimeMillis, 50000L)) != null) {
            b.k("play_session", P);
            b.flush();
        }
        if (this.ppP.o() == 0) {
            return false;
        }
        JSONObject b = this.ppP.b();
        if (b != null) {
            boolean a2 = this.ppX.a(b);
            this.e = System.currentTimeMillis();
            return a2;
        }
        au.a(null);
        return false;
    }

    @Override // com.bytedance.embedapplog.bv
    String e() {
        return "p";
    }
}
