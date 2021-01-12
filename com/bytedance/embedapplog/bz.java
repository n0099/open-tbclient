package com.bytedance.embedapplog;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class bz extends cd {

    /* renamed from: b  reason: collision with root package name */
    private boolean f5818b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bz(Context context, ad adVar, cn cnVar, m mVar) {
        super(context, adVar, cnVar, mVar);
    }

    @Override // com.bytedance.embedapplog.cd, com.bytedance.embedapplog.bv
    long b() {
        return this.f5818b ? Long.MAX_VALUE : 0L;
    }

    @Override // com.bytedance.embedapplog.cd, com.bytedance.embedapplog.bv
    public boolean d() {
        boolean d = super.d();
        this.f5818b = d;
        return d;
    }
}
