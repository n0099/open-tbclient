package com.baidu.tieba.pb.pb.main;

import android.app.Dialog;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ct implements View.OnClickListener {
    final /* synthetic */ ci bMm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ct(ci ciVar) {
        this.bMm = ciVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        Dialog dialog2;
        PbActivity pbActivity;
        dialog = this.bMm.bLD;
        if (dialog instanceof Dialog) {
            dialog2 = this.bMm.bLD;
            pbActivity = this.bMm.bIF;
            com.baidu.adp.lib.g.k.b(dialog2, pbActivity.getPageContext());
        }
    }
}
