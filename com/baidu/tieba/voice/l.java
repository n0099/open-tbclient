package com.baidu.tieba.voice;

import android.app.AlertDialog;
import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ RecordVoiceBnt f2037a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(RecordVoiceBnt recordVoiceBnt) {
        this.f2037a = recordVoiceBnt;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog;
        AlertDialog alertDialog2;
        alertDialog = this.f2037a.G;
        if (alertDialog != null) {
            alertDialog2 = this.f2037a.G;
            alertDialog2.dismiss();
        }
    }
}
