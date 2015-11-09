package com.baidu.tieba.pb.pb.main;

import android.app.Dialog;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class de implements View.OnClickListener {
    final /* synthetic */ ct cmY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public de(ct ctVar) {
        this.cmY = ctVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        Dialog dialog2;
        PbActivity pbActivity;
        dialog = this.cmY.cmq;
        if (dialog instanceof Dialog) {
            dialog2 = this.cmY.cmq;
            pbActivity = this.cmY.cjZ;
            com.baidu.adp.lib.g.j.b(dialog2, pbActivity.getPageContext());
        }
    }
}
