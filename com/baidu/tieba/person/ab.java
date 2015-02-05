package com.baidu.tieba.person;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements DialogInterface.OnCancelListener {
    final /* synthetic */ PersonChangeActivity bHK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(PersonChangeActivity personChangeActivity) {
        this.bHK = personChangeActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        aj ajVar;
        aj ajVar2;
        this.bHK.destroyWaitingDialog();
        ajVar = this.bHK.bHE;
        if (ajVar != null) {
            ajVar2 = this.bHK.bHE;
            ajVar2.cancel();
        }
    }
}
