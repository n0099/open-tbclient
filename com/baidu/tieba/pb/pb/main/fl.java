package com.baidu.tieba.pb.pb.main;

import android.app.Dialog;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fl implements View.OnClickListener {
    final /* synthetic */ ex ewH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fl(ex exVar) {
        this.ewH = exVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        Dialog dialog2;
        PbActivity pbActivity;
        dialog = this.ewH.evr;
        if (dialog instanceof Dialog) {
            dialog2 = this.ewH.evr;
            pbActivity = this.ewH.eow;
            com.baidu.adp.lib.h.j.b(dialog2, pbActivity.getPageContext());
        }
    }
}
