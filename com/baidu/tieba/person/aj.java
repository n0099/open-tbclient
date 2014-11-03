package com.baidu.tieba.person;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements DialogInterface.OnCancelListener {
    final /* synthetic */ PersonChangeActivity bCA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(PersonChangeActivity personChangeActivity) {
        this.bCA = personChangeActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        ar arVar;
        ar arVar2;
        this.bCA.destroyWaitingDialog();
        arVar = this.bCA.bCu;
        if (arVar != null) {
            arVar2 = this.bCA.bCu;
            arVar2.cancel();
        }
    }
}
