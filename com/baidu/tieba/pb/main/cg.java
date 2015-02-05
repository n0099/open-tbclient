package com.baidu.tieba.pb.main;

import android.app.Dialog;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cg implements View.OnClickListener {
    final /* synthetic */ bz bEB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cg(bz bzVar) {
        this.bEB = bzVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        Dialog dialog2;
        PbActivity pbActivity;
        dialog = this.bEB.bDE;
        if (dialog instanceof Dialog) {
            dialog2 = this.bEB.bDE;
            pbActivity = this.bEB.bCF;
            com.baidu.adp.lib.g.k.b(dialog2, pbActivity.getPageContext());
        }
    }
}
