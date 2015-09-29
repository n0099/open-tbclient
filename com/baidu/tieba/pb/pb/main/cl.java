package com.baidu.tieba.pb.pb.main;

import android.app.Dialog;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cl implements View.OnClickListener {
    final /* synthetic */ cc cly;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cl(cc ccVar) {
        this.cly = ccVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        Dialog dialog2;
        PbActivity pbActivity;
        dialog = this.cly.ckR;
        if (dialog instanceof Dialog) {
            dialog2 = this.cly.ckR;
            pbActivity = this.cly.ciJ;
            com.baidu.adp.lib.g.j.b(dialog2, pbActivity.getPageContext());
        }
    }
}
