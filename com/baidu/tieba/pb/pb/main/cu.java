package com.baidu.tieba.pb.pb.main;

import android.app.Dialog;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cu implements View.OnClickListener {
    final /* synthetic */ cj bMC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cu(cj cjVar) {
        this.bMC = cjVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        Dialog dialog2;
        PbActivity pbActivity;
        dialog = this.bMC.bLT;
        if (dialog instanceof Dialog) {
            dialog2 = this.bMC.bLT;
            pbActivity = this.bMC.bIT;
            com.baidu.adp.lib.g.k.b(dialog2, pbActivity.getPageContext());
        }
    }
}
