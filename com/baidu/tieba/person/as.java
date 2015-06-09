package com.baidu.tieba.person;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements DialogInterface.OnCancelListener {
    final /* synthetic */ PersonChangeActivity bSO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(PersonChangeActivity personChangeActivity) {
        this.bSO = personChangeActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        ba baVar;
        ba baVar2;
        this.bSO.destroyWaitingDialog();
        baVar = this.bSO.bSI;
        if (baVar != null) {
            baVar2 = this.bSO.bSI;
            baVar2.cancel();
        }
    }
}
