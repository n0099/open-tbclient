package com.baidu.tieba.person;

import android.content.DialogInterface;
import com.baidu.tieba.person.PersonChangeActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements DialogInterface.OnCancelListener {
    final /* synthetic */ PersonChangeActivity cry;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(PersonChangeActivity personChangeActivity) {
        this.cry = personChangeActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        PersonChangeActivity.b bVar;
        PersonChangeActivity.b bVar2;
        this.cry.destroyWaitingDialog();
        bVar = this.cry.crr;
        if (bVar != null) {
            bVar2 = this.cry.crr;
            bVar2.cancel();
        }
    }
}
