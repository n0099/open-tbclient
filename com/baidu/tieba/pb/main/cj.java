package com.baidu.tieba.pb.main;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class cj implements DialogInterface.OnKeyListener {
    final /* synthetic */ bm a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cj(bm bmVar) {
        this.a = bmVar;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        PbActivity pbActivity;
        EditText editText;
        Dialog dialog;
        if (i == 4) {
            pbActivity = this.a.m;
            editText = this.a.P;
            com.baidu.adp.lib.util.i.a(pbActivity, editText);
            dialog = this.a.L;
            dialog.dismiss();
            return true;
        }
        return false;
    }
}
