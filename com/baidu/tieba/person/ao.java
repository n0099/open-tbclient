package com.baidu.tieba.person;

import android.content.DialogInterface;
import com.baidu.tieba.person.PersonChangeActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements DialogInterface.OnCancelListener {
    final /* synthetic */ PersonChangeActivity dth;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(PersonChangeActivity personChangeActivity) {
        this.dth = personChangeActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        PersonChangeActivity.b bVar;
        PersonChangeActivity.b bVar2;
        this.dth.destroyWaitingDialog();
        bVar = this.dth.dta;
        if (bVar != null) {
            bVar2 = this.dth.dta;
            bVar2.cancel();
        }
    }
}
