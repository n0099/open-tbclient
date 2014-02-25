package com.baidu.tieba.person;

import android.app.Dialog;
import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements DialogInterface.OnClickListener {
    final /* synthetic */ ad a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ad adVar) {
        this.a = adVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Dialog dialog;
        dialog = this.a.j;
        dialog.dismiss();
    }
}
