package com.baidu.tieba;

import android.app.AlertDialog;
import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements DialogInterface.OnClickListener {
    final /* synthetic */ MainTabActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(MainTabActivity mainTabActivity) {
        this.a = mainTabActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog;
        if (i != -2) {
            alertDialog = this.a.x;
            alertDialog.dismiss();
            TiebaApplication.b().a(false, true);
            return;
        }
        this.a.a(true);
        TiebaApplication.b().a(true, true);
    }
}
