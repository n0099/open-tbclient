package com.baidu.tieba.pb.main;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cn implements DialogInterface.OnKeyListener {
    final /* synthetic */ bv byI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cn(bv bvVar) {
        this.byI = bvVar;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        PbActivity pbActivity;
        EditText editText;
        Dialog dialog;
        Dialog dialog2;
        PbActivity pbActivity2;
        if (i == 4) {
            pbActivity = this.byI.bwQ;
            editText = this.byI.bxI;
            com.baidu.adp.lib.util.m.b(pbActivity, editText);
            dialog = this.byI.bxF;
            if (dialog instanceof Dialog) {
                dialog2 = this.byI.bxF;
                pbActivity2 = this.byI.bwQ;
                com.baidu.adp.lib.g.j.b(dialog2, pbActivity2);
            }
            return true;
        }
        return false;
    }
}
