package com.baidu.tieba.signall;

import android.app.AlertDialog;
import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements DialogInterface.OnClickListener {
    final /* synthetic */ SignAllForumActivity bPs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(SignAllForumActivity signAllForumActivity) {
        this.bPs = signAllForumActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog;
        alertDialog = this.bPs.mDialog;
        alertDialog.dismiss();
    }
}
