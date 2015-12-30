package com.baidu.tieba.pb.pb.main;

import android.app.Dialog;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dv implements View.OnClickListener {
    final /* synthetic */ dk cKg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dv(dk dkVar) {
        this.cKg = dkVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        Dialog dialog2;
        PbActivity pbActivity;
        dialog = this.cKg.cJg;
        if (dialog instanceof Dialog) {
            dialog2 = this.cKg.cJg;
            pbActivity = this.cKg.cGj;
            com.baidu.adp.lib.h.j.b(dialog2, pbActivity.getPageContext());
        }
    }
}
