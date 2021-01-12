package com.baidu.ufosdk.ui;

import android.view.View;
/* loaded from: classes7.dex */
final class cr implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cg f5504a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cr(cg cgVar) {
        this.f5504a = cgVar;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        this.f5504a.f5489a.a(view);
        return false;
    }
}
