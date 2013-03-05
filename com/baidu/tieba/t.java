package com.baidu.tieba;

import android.app.AlertDialog;
import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements DialogInterface.OnClickListener {
    final /* synthetic */ MainTabActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(MainTabActivity mainTabActivity) {
        this.a = mainTabActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog;
        if (i != -2) {
            alertDialog = this.a.y;
            alertDialog.dismiss();
            TiebaApplication.b().a(false, false);
            return;
        }
        this.a.a(false);
        TiebaApplication.b().a(true, false);
    }
}
