package com.baidu.tieba.pb;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.widget.EditText;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ch implements DialogInterface.OnKeyListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bo f1537a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ch(bo boVar) {
        this.f1537a = boVar;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        com.baidu.tieba.g gVar;
        EditText editText;
        Dialog dialog;
        if (i == 4) {
            gVar = this.f1537a.b;
            editText = this.f1537a.C;
            UtilHelper.a(gVar, editText);
            dialog = this.f1537a.y;
            dialog.dismiss();
            return true;
        }
        return false;
    }
}
