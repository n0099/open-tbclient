package com.baidu.tieba.pb.pb.main;

import android.app.Dialog;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ck implements View.OnClickListener {
    final /* synthetic */ cb cfj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ck(cb cbVar) {
        this.cfj = cbVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        Dialog dialog2;
        PbActivity pbActivity;
        dialog = this.cfj.ceB;
        if (dialog instanceof Dialog) {
            dialog2 = this.cfj.ceB;
            pbActivity = this.cfj.cbx;
            com.baidu.adp.lib.g.j.b(dialog2, pbActivity.getPageContext());
        }
    }
}
