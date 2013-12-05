package com.baidu.tieba.person;

import android.app.Dialog;
import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonChangeActivity f2312a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(PersonChangeActivity personChangeActivity) {
        this.f2312a = personChangeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Dialog dialog;
        Dialog dialog2;
        dialog = this.f2312a.F;
        if (dialog != null) {
            dialog2 = this.f2312a.F;
            dialog2.dismiss();
        }
    }
}
