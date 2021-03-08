package com.bytedance.embedapplog;

import android.content.Context;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class bu extends bv {
    private boolean b;
    private final m ppQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bu(Context context, m mVar) {
        super(context);
        this.ppQ = mVar;
    }

    @Override // com.bytedance.embedapplog.bv
    boolean a() {
        return true;
    }

    @Override // com.bytedance.embedapplog.bv
    long b() {
        return this.b ? Long.MAX_VALUE : 0L;
    }

    @Override // com.bytedance.embedapplog.bv
    long[] eon() {
        return cc.ppW;
    }

    @Override // com.bytedance.embedapplog.bv
    boolean d() {
        if (this.ppQ.o() != 0) {
            JSONObject a2 = this.ppQ.a();
            if (a2 != null) {
                this.b = aa.x(ab.a(this.f3924a, this.ppQ.a(), aa.eoj().eot(), true, b.enE()), a2);
            } else {
                au.a(null);
            }
        }
        return this.b;
    }

    @Override // com.bytedance.embedapplog.bv
    String e() {
        return "ac";
    }
}
