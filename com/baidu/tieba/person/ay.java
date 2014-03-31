package com.baidu.tieba.person;

import android.content.DialogInterface;
/* loaded from: classes.dex */
final class ay implements DialogInterface.OnCancelListener {
    final /* synthetic */ PersonChangeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(PersonChangeActivity personChangeActivity) {
        this.a = personChangeActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        bg bgVar;
        bg bgVar2;
        this.a.DeinitWaitingDialog();
        bgVar = this.a.x;
        if (bgVar != null) {
            bgVar2 = this.a.x;
            bgVar2.cancel();
        }
    }
}
