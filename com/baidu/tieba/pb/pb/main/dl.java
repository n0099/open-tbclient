package com.baidu.tieba.pb.pb.main;

import android.app.Dialog;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dl implements View.OnClickListener {
    final /* synthetic */ da cGh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dl(da daVar) {
        this.cGh = daVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        Dialog dialog2;
        PbActivity pbActivity;
        dialog = this.cGh.cFh;
        if (dialog instanceof Dialog) {
            dialog2 = this.cGh.cFh;
            pbActivity = this.cGh.cCy;
            com.baidu.adp.lib.h.j.b(dialog2, pbActivity.getPageContext());
        }
    }
}
