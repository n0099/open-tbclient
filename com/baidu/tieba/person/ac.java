package com.baidu.tieba.person;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements DialogInterface.OnCancelListener {
    final /* synthetic */ PersonChangeActivity bGa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(PersonChangeActivity personChangeActivity) {
        this.bGa = personChangeActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        ak akVar;
        ak akVar2;
        this.bGa.destroyWaitingDialog();
        akVar = this.bGa.bFU;
        if (akVar != null) {
            akVar2 = this.bGa.bFU;
            akVar2.cancel();
        }
    }
}
