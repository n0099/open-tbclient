package com.baidu.tieba.pb.pb.main;

import android.app.Dialog;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class gj implements View.OnClickListener {
    final /* synthetic */ fx evi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gj(fx fxVar) {
        this.evi = fxVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        Dialog dialog2;
        PbActivity pbActivity;
        dialog = this.evi.etQ;
        if (dialog instanceof Dialog) {
            dialog2 = this.evi.etQ;
            pbActivity = this.evi.elf;
            com.baidu.adp.lib.g.j.b(dialog2, pbActivity.getPageContext());
        }
    }
}
