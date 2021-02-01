package com.bytedance.embedapplog;

import android.content.Context;
import android.os.Bundle;
import com.kwad.sdk.collector.AppStatusRules;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class cb extends bv {
    private static final long[] pnm = {AppStatusRules.DEFAULT_GRANULARITY};
    private long e;
    private final m pnf;
    private final ad pnn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cb(Context context, m mVar, ad adVar) {
        super(context);
        this.pnn = adVar;
        this.pnf = mVar;
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
    long[] enU() {
        return pnm;
    }

    @Override // com.bytedance.embedapplog.bv
    public boolean d() {
        Bundle P;
        long currentTimeMillis = System.currentTimeMillis();
        ce enW = bx.enW();
        if (enW != null && (P = enW.P(currentTimeMillis, 50000L)) != null) {
            b.k("play_session", P);
            b.flush();
        }
        if (this.pnf.o() == 0) {
            return false;
        }
        JSONObject b2 = this.pnf.b();
        if (b2 != null) {
            boolean a2 = this.pnn.a(b2);
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
