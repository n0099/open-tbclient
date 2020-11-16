package com.baidu.ufosdk.ui;

import android.view.View;
/* loaded from: classes21.dex */
final class fc implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ fa f3874a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fc(fa faVar) {
        this.f3874a = faVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.f3874a == null || !this.f3874a.isShowing()) {
            return;
        }
        this.f3874a.dismiss();
    }
}
