package com.baidu.tieba.pb;

import android.app.Dialog;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dc implements View.OnClickListener {
    final /* synthetic */ cu a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dc(cu cuVar) {
        this.a = cuVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        dialog = this.a.M;
        dialog.dismiss();
    }
}
