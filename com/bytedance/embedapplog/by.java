package com.bytedance.embedapplog;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class by extends cb {
    private boolean b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(Context context, m mVar, ad adVar) {
        super(context, mVar, adVar);
    }

    @Override // com.bytedance.embedapplog.cb, com.bytedance.embedapplog.bv
    long b() {
        return this.b ? Long.MAX_VALUE : 0L;
    }

    @Override // com.bytedance.embedapplog.cb, com.bytedance.embedapplog.bv
    public boolean d() {
        boolean d = super.d();
        this.b = d;
        return d;
    }
}
