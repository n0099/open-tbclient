package com.baidu.tieba.voice;

import android.app.AlertDialog;
import android.content.DialogInterface;
/* loaded from: classes.dex */
final class b implements DialogInterface.OnClickListener {
    final /* synthetic */ RecordVoiceBnt a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(RecordVoiceBnt recordVoiceBnt) {
        this.a = recordVoiceBnt;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog;
        AlertDialog alertDialog2;
        alertDialog = this.a.C;
        if (alertDialog != null) {
            alertDialog2 = this.a.C;
            alertDialog2.dismiss();
        }
    }
}
