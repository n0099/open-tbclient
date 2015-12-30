package com.baidu.tieba.person;

import android.content.DialogInterface;
import com.baidu.tieba.person.PersonChangeActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements DialogInterface.OnCancelListener {
    final /* synthetic */ PersonChangeActivity cPi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(PersonChangeActivity personChangeActivity) {
        this.cPi = personChangeActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        PersonChangeActivity.b bVar;
        PersonChangeActivity.b bVar2;
        this.cPi.destroyWaitingDialog();
        bVar = this.cPi.cPb;
        if (bVar != null) {
            bVar2 = this.cPi.cPb;
            bVar2.cancel();
        }
    }
}
