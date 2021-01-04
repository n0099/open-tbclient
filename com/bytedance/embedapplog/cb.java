package com.bytedance.embedapplog;

import android.content.Context;
import android.os.Bundle;
import com.kwad.sdk.collector.AppStatusRules;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class cb extends bv {
    private static final long[] phA = {AppStatusRules.DEFAULT_GRANULARITY};
    private long e;
    private final ad phB;
    private final m pht;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cb(Context context, m mVar, ad adVar) {
        super(context);
        this.phB = adVar;
        this.pht = mVar;
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
    long[] epw() {
        return phA;
    }

    @Override // com.bytedance.embedapplog.bv
    public boolean d() {
        Bundle L;
        long currentTimeMillis = System.currentTimeMillis();
        ce epy = bx.epy();
        if (epy != null && (L = epy.L(currentTimeMillis, 50000L)) != null) {
            b.j("play_session", L);
            b.flush();
        }
        if (this.pht.o() == 0) {
            return false;
        }
        JSONObject b2 = this.pht.b();
        if (b2 != null) {
            boolean a2 = this.phB.a(b2);
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
