package com.baidu.tieba.pb;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cc implements DialogInterface.OnKeyListener {
    final /* synthetic */ bl a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(bl blVar) {
        this.a = blVar;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        com.baidu.tieba.e eVar;
        EditText editText;
        Dialog dialog;
        if (i == 4) {
            eVar = this.a.b;
            editText = this.a.C;
            com.baidu.tieba.d.ag.a(eVar, editText);
            dialog = this.a.y;
            dialog.dismiss();
            return true;
        }
        return false;
    }
}
