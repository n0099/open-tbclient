package com.baidu.tieba.pb.main;

import android.app.Dialog;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bz implements View.OnClickListener {
    final /* synthetic */ bs a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bz(bs bsVar) {
        this.a = bsVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        dialog = this.a.ae;
        dialog.dismiss();
    }
}
