package com.baidu.tieba.pb.main;

import android.app.Dialog;
import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements DialogInterface.OnClickListener {
    final /* synthetic */ PbActivity bvu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(PbActivity pbActivity) {
        this.bvu = pbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (dialogInterface instanceof Dialog) {
            com.baidu.adp.lib.g.j.b((Dialog) dialogInterface, this.bvu);
        }
    }
}
