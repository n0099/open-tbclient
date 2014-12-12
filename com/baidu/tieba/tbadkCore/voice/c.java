package com.baidu.tieba.tbadkCore.voice;

import android.app.AlertDialog;
import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements DialogInterface.OnClickListener {
    final /* synthetic */ a bZA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bZA = aVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog;
        AlertDialog alertDialog2;
        alertDialog = this.bZA.mDialog;
        if (alertDialog != null) {
            alertDialog2 = this.bZA.mDialog;
            alertDialog2.dismiss();
        }
    }
}
