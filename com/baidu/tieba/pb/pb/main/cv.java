package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cv implements DialogInterface.OnKeyListener {
    final /* synthetic */ ci bMm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cv(ci ciVar) {
        this.bMm = ciVar;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        PbActivity pbActivity;
        EditText editText;
        Dialog dialog;
        Dialog dialog2;
        PbActivity pbActivity2;
        if (i == 4) {
            pbActivity = this.bMm.bIF;
            Activity pageActivity = pbActivity.getPageContext().getPageActivity();
            editText = this.bMm.bLm;
            com.baidu.adp.lib.util.n.c(pageActivity, editText);
            dialog = this.bMm.bLj;
            if (dialog instanceof Dialog) {
                dialog2 = this.bMm.bLj;
                pbActivity2 = this.bMm.bIF;
                com.baidu.adp.lib.g.k.b(dialog2, pbActivity2.getPageContext());
            }
            return true;
        }
        return false;
    }
}
