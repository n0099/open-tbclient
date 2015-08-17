package com.baidu.tieba.person;

import android.content.DialogInterface;
import com.baidu.tieba.person.PersonChangeActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements DialogInterface.OnCancelListener {
    final /* synthetic */ PersonChangeActivity cjt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(PersonChangeActivity personChangeActivity) {
        this.cjt = personChangeActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        PersonChangeActivity.b bVar;
        PersonChangeActivity.b bVar2;
        this.cjt.destroyWaitingDialog();
        bVar = this.cjt.cjn;
        if (bVar != null) {
            bVar2 = this.cjt.cjn;
            bVar2.cancel();
        }
    }
}
