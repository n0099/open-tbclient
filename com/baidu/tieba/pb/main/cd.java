package com.baidu.tieba.pb.main;

import android.app.Dialog;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cd implements View.OnClickListener {
    final /* synthetic */ bv byI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(bv bvVar) {
        this.byI = bvVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        Dialog dialog2;
        PbActivity pbActivity;
        dialog = this.byI.bxO;
        if (dialog instanceof Dialog) {
            dialog2 = this.byI.bxO;
            pbActivity = this.byI.bwQ;
            com.baidu.adp.lib.g.j.b(dialog2, pbActivity);
        }
    }
}
