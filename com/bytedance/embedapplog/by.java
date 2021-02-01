package com.bytedance.embedapplog;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class by extends cb {

    /* renamed from: b  reason: collision with root package name */
    private boolean f5819b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(Context context, m mVar, ad adVar) {
        super(context, mVar, adVar);
    }

    @Override // com.bytedance.embedapplog.cb, com.bytedance.embedapplog.bv
    long b() {
        return this.f5819b ? Long.MAX_VALUE : 0L;
    }

    @Override // com.bytedance.embedapplog.cb, com.bytedance.embedapplog.bv
    public boolean d() {
        boolean d = super.d();
        this.f5819b = d;
        return d;
    }
}
