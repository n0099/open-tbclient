package com.baidu.tieba.pb.main;

import android.app.Dialog;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ch implements View.OnClickListener {
    final /* synthetic */ bz bCR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ch(bz bzVar) {
        this.bCR = bzVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        Dialog dialog2;
        PbActivity pbActivity;
        dialog = this.bCR.bBU;
        if (dialog instanceof Dialog) {
            dialog2 = this.bCR.bBU;
            pbActivity = this.bCR.bAW;
            com.baidu.adp.lib.g.k.b(dialog2, pbActivity.getPageContext());
        }
    }
}
