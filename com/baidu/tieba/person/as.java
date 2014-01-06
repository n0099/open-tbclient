package com.baidu.tieba.person;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements DialogInterface.OnCancelListener {
    final /* synthetic */ PersonChangeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(PersonChangeActivity personChangeActivity) {
        this.a = personChangeActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        bf bfVar;
        bf bfVar2;
        this.a.DeinitWaitingDialog();
        bfVar = this.a.B;
        if (bfVar != null) {
            bfVar2 = this.a.B;
            bfVar2.cancel();
        }
    }
}
