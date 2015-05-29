package com.baidu.tieba.person;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements DialogInterface.OnCancelListener {
    final /* synthetic */ PersonChangeActivity bSN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(PersonChangeActivity personChangeActivity) {
        this.bSN = personChangeActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        ba baVar;
        ba baVar2;
        this.bSN.destroyWaitingDialog();
        baVar = this.bSN.bSH;
        if (baVar != null) {
            baVar2 = this.bSN.bSH;
            baVar2.cancel();
        }
    }
}
