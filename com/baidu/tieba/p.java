package com.baidu.tieba;

import android.app.AlertDialog;
import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements DialogInterface.OnClickListener {
    final /* synthetic */ MainTabActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(MainTabActivity mainTabActivity) {
        this.a = mainTabActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog;
        if (i == -2) {
            this.a.a(false);
            TiebaApplication.a().a(true, false);
            return;
        }
        alertDialog = this.a.v;
        alertDialog.dismiss();
        TiebaApplication.a().a(false, false);
    }
}
