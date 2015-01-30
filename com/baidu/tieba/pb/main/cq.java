package com.baidu.tieba.pb.main;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cq implements DialogInterface.OnKeyListener {
    final /* synthetic */ bz bEC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cq(bz bzVar) {
        this.bEC = bzVar;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        PbActivity pbActivity;
        EditText editText;
        Dialog dialog;
        Dialog dialog2;
        PbActivity pbActivity2;
        if (i == 4) {
            pbActivity = this.bEC.bCG;
            Activity pageActivity = pbActivity.getPageContext().getPageActivity();
            editText = this.bEC.bDy;
            com.baidu.adp.lib.util.l.c(pageActivity, editText);
            dialog = this.bEC.bDu;
            if (dialog instanceof Dialog) {
                dialog2 = this.bEC.bDu;
                pbActivity2 = this.bEC.bCG;
                com.baidu.adp.lib.g.k.b(dialog2, pbActivity2.getPageContext());
            }
            return true;
        }
        return false;
    }
}
