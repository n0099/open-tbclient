package com.baidu.ufosdk.ui;

import android.view.View;
/* loaded from: classes22.dex */
final class fb implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ fa f3876a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fb(fa faVar) {
        this.f3876a = faVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.f3876a == null || !this.f3876a.isShowing()) {
            return;
        }
        this.f3876a.dismiss();
    }
}
