package com.baidu.tieba.person;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements DialogInterface.OnCancelListener {
    final /* synthetic */ PersonChangeActivity bCm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(PersonChangeActivity personChangeActivity) {
        this.bCm = personChangeActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        ar arVar;
        ar arVar2;
        this.bCm.destroyWaitingDialog();
        arVar = this.bCm.bCg;
        if (arVar != null) {
            arVar2 = this.bCm.bCg;
            arVar2.cancel();
        }
    }
}
