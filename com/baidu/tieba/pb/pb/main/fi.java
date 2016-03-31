package com.baidu.tieba.pb.pb.main;

import android.app.Dialog;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fi implements View.OnClickListener {
    final /* synthetic */ eu dnc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fi(eu euVar) {
        this.dnc = euVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        Dialog dialog2;
        PbActivity pbActivity;
        dialog = this.dnc.dlJ;
        if (dialog instanceof Dialog) {
            dialog2 = this.dnc.dlJ;
            pbActivity = this.dnc.dfw;
            com.baidu.adp.lib.h.j.b(dialog2, pbActivity.getPageContext());
        }
    }
}
