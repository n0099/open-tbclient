package com.baidu.tieba.pb;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cg implements DialogInterface.OnKeyListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bn f1499a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cg(bn bnVar) {
        this.f1499a = bnVar;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        com.baidu.tieba.g gVar;
        EditText editText;
        Dialog dialog;
        if (i == 4) {
            gVar = this.f1499a.b;
            editText = this.f1499a.B;
            com.baidu.tieba.util.am.a(gVar, editText);
            dialog = this.f1499a.x;
            dialog.dismiss();
            return true;
        }
        return false;
    }
}
