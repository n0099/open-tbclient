package com.baidu.ufosdk.ui;

import android.view.View;
/* loaded from: classes5.dex */
public final class fc implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ fa f22950a;

    public fc(fa faVar) {
        this.f22950a = faVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        fa faVar = this.f22950a;
        if (faVar == null || !faVar.isShowing()) {
            return;
        }
        this.f22950a.dismiss();
    }
}
