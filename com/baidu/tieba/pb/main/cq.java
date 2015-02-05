package com.baidu.tieba.pb.main;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cq implements DialogInterface.OnKeyListener {
    final /* synthetic */ bz bEB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cq(bz bzVar) {
        this.bEB = bzVar;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        PbActivity pbActivity;
        EditText editText;
        Dialog dialog;
        Dialog dialog2;
        PbActivity pbActivity2;
        if (i == 4) {
            pbActivity = this.bEB.bCF;
            Activity pageActivity = pbActivity.getPageContext().getPageActivity();
            editText = this.bEB.bDx;
            com.baidu.adp.lib.util.l.c(pageActivity, editText);
            dialog = this.bEB.bDt;
            if (dialog instanceof Dialog) {
                dialog2 = this.bEB.bDt;
                pbActivity2 = this.bEB.bCF;
                com.baidu.adp.lib.g.k.b(dialog2, pbActivity2.getPageContext());
            }
            return true;
        }
        return false;
    }
}
