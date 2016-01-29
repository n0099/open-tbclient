package com.baidu.tieba.person;

import android.content.DialogInterface;
import com.baidu.tieba.person.PersonChangeActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements DialogInterface.OnCancelListener {
    final /* synthetic */ PersonChangeActivity cYF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(PersonChangeActivity personChangeActivity) {
        this.cYF = personChangeActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        PersonChangeActivity.b bVar;
        PersonChangeActivity.b bVar2;
        this.cYF.destroyWaitingDialog();
        bVar = this.cYF.cYy;
        if (bVar != null) {
            bVar2 = this.cYF.cYy;
            bVar2.cancel();
        }
    }
}
