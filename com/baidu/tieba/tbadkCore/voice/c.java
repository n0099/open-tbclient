package com.baidu.tieba.tbadkCore.voice;

import android.app.AlertDialog;
import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements DialogInterface.OnClickListener {
    final /* synthetic */ a cbt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.cbt = aVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog;
        AlertDialog alertDialog2;
        alertDialog = this.cbt.mDialog;
        if (alertDialog != null) {
            alertDialog2 = this.cbt.mDialog;
            alertDialog2.dismiss();
        }
    }
}
