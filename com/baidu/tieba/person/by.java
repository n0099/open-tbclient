package com.baidu.tieba.person;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class by implements DialogInterface.OnCancelListener {
    final /* synthetic */ PersonChangeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(PersonChangeActivity personChangeActivity) {
        this.a = personChangeActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        cg cgVar;
        cg cgVar2;
        this.a.DeinitWaitingDialog();
        cgVar = this.a.z;
        if (cgVar != null) {
            cgVar2 = this.a.z;
            cgVar2.cancel();
        }
    }
}
