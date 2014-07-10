package com.baidu.tieba.pb.main;

import android.app.Dialog;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cb implements View.OnClickListener {
    final /* synthetic */ bt a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cb(bt btVar) {
        this.a = btVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        dialog = this.a.ae;
        dialog.dismiss();
    }
}
