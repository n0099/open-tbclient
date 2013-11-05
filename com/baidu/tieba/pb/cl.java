package com.baidu.tieba.pb;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.widget.EditText;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cl implements DialogInterface.OnKeyListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bt f2099a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cl(bt btVar) {
        this.f2099a = btVar;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        NewPbActivity newPbActivity;
        EditText editText;
        Dialog dialog;
        if (i == 4) {
            newPbActivity = this.f2099a.c;
            editText = this.f2099a.G;
            UtilHelper.a(newPbActivity, editText);
            dialog = this.f2099a.C;
            dialog.dismiss();
            return true;
        }
        return false;
    }
}
