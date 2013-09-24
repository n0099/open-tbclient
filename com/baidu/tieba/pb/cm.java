package com.baidu.tieba.pb;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.widget.EditText;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cm implements DialogInterface.OnKeyListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ br f1584a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cm(br brVar) {
        this.f1584a = brVar;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        NewPbActivity newPbActivity;
        EditText editText;
        Dialog dialog;
        if (i == 4) {
            newPbActivity = this.f1584a.c;
            editText = this.f1584a.G;
            UtilHelper.a(newPbActivity, editText);
            dialog = this.f1584a.C;
            dialog.dismiss();
            return true;
        }
        return false;
    }
}
