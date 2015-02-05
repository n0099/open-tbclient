package com.baidu.tieba.tbadkCore.voice;

import android.app.AlertDialog;
import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements DialogInterface.OnClickListener {
    final /* synthetic */ a cbs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.cbs = aVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog;
        AlertDialog alertDialog2;
        alertDialog = this.cbs.mDialog;
        if (alertDialog != null) {
            alertDialog2 = this.cbs.mDialog;
            alertDialog2.dismiss();
        }
    }
}
