package com.baidu.tieba.pb.pb.main;

import android.app.Dialog;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ez implements View.OnClickListener {
    final /* synthetic */ el dpu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ez(el elVar) {
        this.dpu = elVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        Dialog dialog2;
        PbActivity pbActivity;
        dialog = this.dpu.doe;
        if (dialog instanceof Dialog) {
            dialog2 = this.dpu.doe;
            pbActivity = this.dpu.dhY;
            com.baidu.adp.lib.h.j.b(dialog2, pbActivity.getPageContext());
        }
    }
}
