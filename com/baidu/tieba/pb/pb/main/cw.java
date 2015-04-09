package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cw implements DialogInterface.OnKeyListener {
    final /* synthetic */ cj bMC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cw(cj cjVar) {
        this.bMC = cjVar;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        PbActivity pbActivity;
        EditText editText;
        Dialog dialog;
        Dialog dialog2;
        PbActivity pbActivity2;
        if (i == 4) {
            pbActivity = this.bMC.bIT;
            Activity pageActivity = pbActivity.getPageContext().getPageActivity();
            editText = this.bMC.bLB;
            com.baidu.adp.lib.util.n.c(pageActivity, editText);
            dialog = this.bMC.bLy;
            if (dialog instanceof Dialog) {
                dialog2 = this.bMC.bLy;
                pbActivity2 = this.bMC.bIT;
                com.baidu.adp.lib.g.k.b(dialog2, pbActivity2.getPageContext());
            }
            return true;
        }
        return false;
    }
}
