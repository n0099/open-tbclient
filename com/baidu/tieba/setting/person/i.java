package com.baidu.tieba.setting.person;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements DialogInterface.OnCancelListener {
    final /* synthetic */ PersonChangeActivity ccU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(PersonChangeActivity personChangeActivity) {
        this.ccU = personChangeActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        q qVar;
        q qVar2;
        this.ccU.destroyWaitingDialog();
        qVar = this.ccU.ccO;
        if (qVar != null) {
            qVar2 = this.ccU.ccO;
            qVar2.cancel();
        }
    }
}
