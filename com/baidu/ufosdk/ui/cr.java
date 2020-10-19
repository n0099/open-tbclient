package com.baidu.ufosdk.ui;

import android.view.View;
/* loaded from: classes22.dex */
final class cr implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cg f3812a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cr(cg cgVar) {
        this.f3812a = cgVar;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        this.f3812a.f3801a.a(view);
        return false;
    }
}
