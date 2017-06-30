package com.baidu.tieba.pb.pb.main;

import android.app.Dialog;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class gs implements View.OnClickListener {
    final /* synthetic */ gg eEv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gs(gg ggVar) {
        this.eEv = ggVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        Dialog dialog2;
        PbActivity pbActivity;
        dialog = this.eEv.eDa;
        if (dialog instanceof Dialog) {
            dialog2 = this.eEv.eDa;
            pbActivity = this.eEv.euf;
            com.baidu.adp.lib.g.j.b(dialog2, pbActivity.getPageContext());
        }
    }
}
