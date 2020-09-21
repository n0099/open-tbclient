package com.baidu.ufosdk.ui;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes21.dex */
public final class fc implements View.OnClickListener {
    final /* synthetic */ fa a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fc(fa faVar) {
        this.a = faVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.a == null || !this.a.isShowing()) {
            return;
        }
        this.a.dismiss();
    }
}
