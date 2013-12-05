package com.baidu.tieba.voice;

import android.app.AlertDialog;
import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ RecordVoiceBnt f2730a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(RecordVoiceBnt recordVoiceBnt) {
        this.f2730a = recordVoiceBnt;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog;
        AlertDialog alertDialog2;
        alertDialog = this.f2730a.G;
        if (alertDialog != null) {
            alertDialog2 = this.f2730a.G;
            alertDialog2.dismiss();
        }
    }
}
