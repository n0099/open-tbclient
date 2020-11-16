package com.baidu.ufosdk.ui;

import android.view.View;
/* loaded from: classes21.dex */
final class fb implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ fa f3873a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fb(fa faVar) {
        this.f3873a = faVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.f3873a == null || !this.f3873a.isShowing()) {
            return;
        }
        this.f3873a.dismiss();
    }
}
