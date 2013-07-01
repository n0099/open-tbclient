package com.baidu.tieba.pb;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cd implements DialogInterface.OnKeyListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bk f1248a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(bk bkVar) {
        this.f1248a = bkVar;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        com.baidu.tieba.g gVar;
        EditText editText;
        Dialog dialog;
        if (i == 4) {
            gVar = this.f1248a.b;
            editText = this.f1248a.B;
            com.baidu.tieba.util.ab.a(gVar, editText);
            dialog = this.f1248a.x;
            dialog.dismiss();
            return true;
        }
        return false;
    }
}
