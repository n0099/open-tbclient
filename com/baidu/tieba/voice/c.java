package com.baidu.tieba.voice;

import android.app.AlertDialog;
import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements DialogInterface.OnClickListener {
    final /* synthetic */ a bSn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bSn = aVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog;
        AlertDialog alertDialog2;
        alertDialog = this.bSn.Bf;
        if (alertDialog != null) {
            alertDialog2 = this.bSn.Bf;
            alertDialog2.dismiss();
        }
    }
}
