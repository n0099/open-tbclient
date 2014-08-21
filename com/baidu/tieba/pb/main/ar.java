package com.baidu.tieba.pb.main;

import android.app.Dialog;
import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements DialogInterface.OnClickListener {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (dialogInterface instanceof Dialog) {
            com.baidu.adp.lib.e.e.b((Dialog) dialogInterface, this.a);
        }
    }
}
