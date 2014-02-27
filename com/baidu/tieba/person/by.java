package com.baidu.tieba.person;

import android.content.DialogInterface;
/* loaded from: classes.dex */
final class by implements DialogInterface.OnCancelListener {
    final /* synthetic */ PersonChangeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(PersonChangeActivity personChangeActivity) {
        this.a = personChangeActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
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
