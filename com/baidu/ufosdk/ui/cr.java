package com.baidu.ufosdk.ui;

import android.view.View;
/* loaded from: classes8.dex */
final class cr implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cg f5786a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cr(cg cgVar) {
        this.f5786a = cgVar;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        this.f5786a.f5771a.a(view);
        return false;
    }
}
