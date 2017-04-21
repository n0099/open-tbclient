package com.baidu.tieba.pb.pb.main;

import android.app.Dialog;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fn implements View.OnClickListener {
    final /* synthetic */ ey etN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fn(ey eyVar) {
        this.etN = eyVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        Dialog dialog2;
        PbActivity pbActivity;
        dialog = this.etN.est;
        if (dialog instanceof Dialog) {
            dialog2 = this.etN.est;
            pbActivity = this.etN.ekw;
            com.baidu.adp.lib.g.j.b(dialog2, pbActivity.getPageContext());
        }
    }
}
