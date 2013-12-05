package com.baidu.tieba.pb;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class di implements DialogInterface.OnKeyListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cr f2231a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public di(cr crVar) {
        this.f2231a = crVar;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        NewPbActivity newPbActivity;
        EditText editText;
        Dialog dialog;
        if (i == 4) {
            newPbActivity = this.f2231a.g;
            editText = this.f2231a.s;
            com.baidu.adp.lib.h.g.a(newPbActivity, editText);
            dialog = this.f2231a.o;
            dialog.dismiss();
            return true;
        }
        return false;
    }
}
