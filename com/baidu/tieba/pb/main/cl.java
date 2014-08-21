package com.baidu.tieba.pb.main;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cl implements DialogInterface.OnKeyListener {
    final /* synthetic */ bs a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cl(bs bsVar) {
        this.a = bsVar;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        PbActivity pbActivity;
        EditText editText;
        Dialog dialog;
        Dialog dialog2;
        PbActivity pbActivity2;
        if (i == 4) {
            pbActivity = this.a.k;
            editText = this.a.O;
            com.baidu.adp.lib.util.j.a(pbActivity, editText);
            dialog = this.a.K;
            if (dialog instanceof Dialog) {
                dialog2 = this.a.K;
                pbActivity2 = this.a.k;
                com.baidu.adp.lib.e.e.b(dialog2, pbActivity2);
            }
            return true;
        }
        return false;
    }
}
