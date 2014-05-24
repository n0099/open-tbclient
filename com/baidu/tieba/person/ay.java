package com.baidu.tieba.person;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements DialogInterface.OnCancelListener {
    final /* synthetic */ PersonChangeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(PersonChangeActivity personChangeActivity) {
        this.a = personChangeActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        bg bgVar;
        bg bgVar2;
        this.a.destroyWaitingDialog();
        bgVar = this.a.x;
        if (bgVar != null) {
            bgVar2 = this.a.x;
            bgVar2.cancel();
        }
    }
}
