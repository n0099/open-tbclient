package com.baidu.ufosdk.ui;

import android.view.View;
/* loaded from: classes21.dex */
final class cm implements View.OnClickListener {
    final /* synthetic */ cg a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cm(cg cgVar) {
        this.a = cgVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.a.a.H) {
            return;
        }
        new Thread(new cn(this)).start();
    }
}
