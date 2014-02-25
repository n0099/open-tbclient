package com.baidu.tieba.pb;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.widget.EditText;
import com.baidu.adp.lib.util.BdUtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dp implements DialogInterface.OnKeyListener {
    final /* synthetic */ cu a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dp(cu cuVar) {
        this.a = cuVar;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        NewPbActivity newPbActivity;
        EditText editText;
        Dialog dialog;
        if (i == 4) {
            newPbActivity = this.a.h;
            editText = this.a.u;
            BdUtilHelper.a(newPbActivity, editText);
            dialog = this.a.q;
            dialog.dismiss();
            return true;
        }
        return false;
    }
}
