package com.baidu.tieba.person;

import android.app.Dialog;
import android.content.DialogInterface;
/* loaded from: classes.dex */
final class av implements DialogInterface.OnClickListener {
    final /* synthetic */ PersonChangeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(PersonChangeActivity personChangeActivity) {
        this.a = personChangeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        Dialog dialog;
        Dialog dialog2;
        dialog = this.a.B;
        if (dialog != null) {
            dialog2 = this.a.B;
            dialog2.dismiss();
        }
        PersonChangeActivity.m(this.a);
    }
}
