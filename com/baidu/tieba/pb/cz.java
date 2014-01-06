package com.baidu.tieba.pb;

import android.app.Dialog;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cz implements View.OnClickListener {
    final /* synthetic */ cs a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cz(cs csVar) {
        this.a = csVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        dialog = this.a.aa;
        dialog.dismiss();
    }
}
