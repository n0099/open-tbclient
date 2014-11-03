package com.baidu.tieba.pb.main;

import android.app.Dialog;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cd implements View.OnClickListener {
    final /* synthetic */ bv byW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(bv bvVar) {
        this.byW = bvVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        Dialog dialog2;
        PbActivity pbActivity;
        dialog = this.byW.byc;
        if (dialog instanceof Dialog) {
            dialog2 = this.byW.byc;
            pbActivity = this.byW.bxe;
            com.baidu.adp.lib.g.j.b(dialog2, pbActivity);
        }
    }
}
