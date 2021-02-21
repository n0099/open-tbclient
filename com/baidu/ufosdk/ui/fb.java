package com.baidu.ufosdk.ui;

import android.view.View;
/* loaded from: classes8.dex */
final class fb implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ fa f5591a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fb(fa faVar) {
        this.f5591a = faVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.f5591a == null || !this.f5591a.isShowing()) {
            return;
        }
        this.f5591a.dismiss();
    }
}
