package com.baidu.tieba.person;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements DialogInterface.OnCancelListener {
    final /* synthetic */ PersonChangeActivity bHL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(PersonChangeActivity personChangeActivity) {
        this.bHL = personChangeActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        aj ajVar;
        aj ajVar2;
        this.bHL.destroyWaitingDialog();
        ajVar = this.bHL.bHF;
        if (ajVar != null) {
            ajVar2 = this.bHL.bHF;
            ajVar2.cancel();
        }
    }
}
