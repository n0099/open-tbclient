package com.baidu.tieba.setting.person;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements DialogInterface.OnCancelListener {
    final /* synthetic */ PersonChangeActivity ccF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(PersonChangeActivity personChangeActivity) {
        this.ccF = personChangeActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        q qVar;
        q qVar2;
        this.ccF.destroyWaitingDialog();
        qVar = this.ccF.ccz;
        if (qVar != null) {
            qVar2 = this.ccF.ccz;
            qVar2.cancel();
        }
    }
}
