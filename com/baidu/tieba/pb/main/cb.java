package com.baidu.tieba.pb.main;

import android.app.Dialog;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cb implements View.OnClickListener {
    final /* synthetic */ bs a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cb(bs bsVar) {
        this.a = bsVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        dialog = this.a.at;
        dialog.dismiss();
    }
}
