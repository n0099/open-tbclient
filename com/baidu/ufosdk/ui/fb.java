package com.baidu.ufosdk.ui;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class fb implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ fa f5589a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fb(fa faVar) {
        this.f5589a = faVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.f5589a == null || !this.f5589a.isShowing()) {
            return;
        }
        this.f5589a.dismiss();
    }
}
