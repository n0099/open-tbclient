package com.baidu.tieba.pb;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cd implements DialogInterface.OnKeyListener {
    final /* synthetic */ bk a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(bk bkVar) {
        this.a = bkVar;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        com.baidu.tieba.g gVar;
        EditText editText;
        Dialog dialog;
        if (i == 4) {
            gVar = this.a.b;
            editText = this.a.B;
            com.baidu.tieba.util.ab.a(gVar, editText);
            dialog = this.a.x;
            dialog.dismiss();
            return true;
        }
        return false;
    }
}
