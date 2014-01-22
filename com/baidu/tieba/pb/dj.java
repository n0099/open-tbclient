package com.baidu.tieba.pb;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dj implements DialogInterface.OnKeyListener {
    final /* synthetic */ cr a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dj(cr crVar) {
        this.a = crVar;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        NewPbActivity newPbActivity;
        EditText editText;
        Dialog dialog;
        if (i == 4) {
            newPbActivity = this.a.g;
            editText = this.a.t;
            com.baidu.adp.lib.g.g.a(newPbActivity, editText);
            dialog = this.a.p;
            dialog.dismiss();
            return true;
        }
        return false;
    }
}
