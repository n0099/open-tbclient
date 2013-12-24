package com.baidu.tieba.voice;

import android.app.AlertDialog;
import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements DialogInterface.OnClickListener {
    final /* synthetic */ RecordVoiceBnt a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(RecordVoiceBnt recordVoiceBnt) {
        this.a = recordVoiceBnt;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog;
        AlertDialog alertDialog2;
        alertDialog = this.a.G;
        if (alertDialog != null) {
            alertDialog2 = this.a.G;
            alertDialog2.dismiss();
        }
    }
}
