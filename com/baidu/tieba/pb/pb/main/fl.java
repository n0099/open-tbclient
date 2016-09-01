package com.baidu.tieba.pb.pb.main;

import android.app.Dialog;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fl implements View.OnClickListener {
    final /* synthetic */ ex euB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fl(ex exVar) {
        this.euB = exVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        Dialog dialog2;
        PbActivity pbActivity;
        dialog = this.euB.etj;
        if (dialog instanceof Dialog) {
            dialog2 = this.euB.etj;
            pbActivity = this.euB.emy;
            com.baidu.adp.lib.h.j.b(dialog2, pbActivity.getPageContext());
        }
    }
}
