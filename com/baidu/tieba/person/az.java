package com.baidu.tieba.person;

import android.content.DialogInterface;
/* loaded from: classes.dex */
final class az implements DialogInterface.OnCancelListener {
    final /* synthetic */ PersonChangeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(PersonChangeActivity personChangeActivity) {
        this.a = personChangeActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        bh bhVar;
        bh bhVar2;
        this.a.DeinitWaitingDialog();
        bhVar = this.a.x;
        if (bhVar != null) {
            bhVar2 = this.a.x;
            bhVar2.cancel();
        }
    }
}
