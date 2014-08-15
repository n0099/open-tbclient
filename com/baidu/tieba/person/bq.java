package com.baidu.tieba.person;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bq implements DialogInterface.OnCancelListener {
    final /* synthetic */ PersonChangeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(PersonChangeActivity personChangeActivity) {
        this.a = personChangeActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        by byVar;
        by byVar2;
        this.a.destroyWaitingDialog();
        byVar = this.a.x;
        if (byVar != null) {
            byVar2 = this.a.x;
            byVar2.cancel();
        }
    }
}
