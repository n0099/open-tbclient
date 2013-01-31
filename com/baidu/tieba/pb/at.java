package com.baidu.tieba.pb;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements DialogInterface.OnKeyListener {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        EditText editText;
        Dialog dialog;
        if (i == 4) {
            PbActivity pbActivity = this.a;
            editText = this.a.k;
            com.baidu.tieba.c.ah.a(pbActivity, editText);
            dialog = this.a.z;
            dialog.dismiss();
            return true;
        }
        return false;
    }
}
