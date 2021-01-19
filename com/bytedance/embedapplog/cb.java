package com.bytedance.embedapplog;

import android.content.Context;
import android.os.Bundle;
import com.kwad.sdk.collector.AppStatusRules;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class cb extends bv {
    private static final long[] pcZ = {AppStatusRules.DEFAULT_GRANULARITY};
    private long e;
    private final m pcS;
    private final ad pda;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cb(Context context, m mVar, ad adVar) {
        super(context);
        this.pda = adVar;
        this.pcS = mVar;
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
    long[] elB() {
        return pcZ;
    }

    @Override // com.bytedance.embedapplog.bv
    public boolean d() {
        Bundle L;
        long currentTimeMillis = System.currentTimeMillis();
        ce elD = bx.elD();
        if (elD != null && (L = elD.L(currentTimeMillis, 50000L)) != null) {
            b.k("play_session", L);
            b.flush();
        }
        if (this.pcS.o() == 0) {
            return false;
        }
        JSONObject b2 = this.pcS.b();
        if (b2 != null) {
            boolean a2 = this.pda.a(b2);
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
