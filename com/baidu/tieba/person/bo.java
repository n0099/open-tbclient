package com.baidu.tieba.person;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bo implements DialogInterface.OnCancelListener {
    final /* synthetic */ PersonChangeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(PersonChangeActivity personChangeActivity) {
        this.a = personChangeActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        bw bwVar;
        bw bwVar2;
        this.a.destroyWaitingDialog();
        bwVar = this.a.x;
        if (bwVar != null) {
            bwVar2 = this.a.x;
            bwVar2.cancel();
        }
    }
}
