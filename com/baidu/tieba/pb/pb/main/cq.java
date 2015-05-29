package com.baidu.tieba.pb.pb.main;

import android.app.Dialog;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cq implements View.OnClickListener {
    final /* synthetic */ ch bOF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cq(ch chVar) {
        this.bOF = chVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        Dialog dialog2;
        PbActivity pbActivity;
        dialog = this.bOF.bNW;
        if (dialog instanceof Dialog) {
            dialog2 = this.bOF.bNW;
            pbActivity = this.bOF.bKZ;
            com.baidu.adp.lib.g.k.b(dialog2, pbActivity.getPageContext());
        }
    }
}
