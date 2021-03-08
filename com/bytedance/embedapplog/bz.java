package com.bytedance.embedapplog;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class bz extends cd {
    private boolean b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bz(Context context, ad adVar, cn cnVar, m mVar) {
        super(context, adVar, cnVar, mVar);
    }

    @Override // com.bytedance.embedapplog.cd, com.bytedance.embedapplog.bv
    long b() {
        return this.b ? Long.MAX_VALUE : 0L;
    }

    @Override // com.bytedance.embedapplog.cd, com.bytedance.embedapplog.bv
    public boolean d() {
        boolean d = super.d();
        this.b = d;
        return d;
    }
}
