package com.baidu.tieba.pb.main;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cm implements DialogInterface.OnKeyListener {
    final /* synthetic */ bt a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cm(bt btVar) {
        this.a = btVar;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        PbActivity pbActivity;
        EditText editText;
        Dialog dialog;
        if (i == 4) {
            pbActivity = this.a.k;
            editText = this.a.N;
            com.baidu.adp.lib.util.j.a(pbActivity, editText);
            dialog = this.a.J;
            dialog.dismiss();
            return true;
        }
        return false;
    }
}
