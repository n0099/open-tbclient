package com.baidu.tieba.pb;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements DialogInterface.OnKeyListener {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        EditText editText;
        Dialog dialog;
        if (i == 4) {
            PbActivity pbActivity = this.a;
            editText = this.a.l;
            com.baidu.tieba.c.ai.a(pbActivity, editText);
            dialog = this.a.A;
            dialog.dismiss();
            return true;
        }
        return false;
    }
}
