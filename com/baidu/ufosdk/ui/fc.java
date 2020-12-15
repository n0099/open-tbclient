package com.baidu.ufosdk.ui;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes22.dex */
public final class fc implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ fa f3877a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fc(fa faVar) {
        this.f3877a = faVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.f3877a == null || !this.f3877a.isShowing()) {
            return;
        }
        this.f3877a.dismiss();
    }
}
