package com.baidu.ufosdk.ui;

import android.view.View;
/* loaded from: classes5.dex */
public final class fb implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ fa f23031a;

    public fb(fa faVar) {
        this.f23031a = faVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        fa faVar = this.f23031a;
        if (faVar == null || !faVar.isShowing()) {
            return;
        }
        this.f23031a.dismiss();
    }
}
