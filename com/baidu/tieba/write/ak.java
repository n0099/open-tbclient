package com.baidu.tieba.write;

import android.content.DialogInterface;
/* loaded from: classes.dex */
final class ak implements DialogInterface.OnCancelListener {
    final /* synthetic */ VcodeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(VcodeActivity vcodeActivity) {
        this.a = vcodeActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        an anVar;
        an anVar2;
        this.a.DeinitWaitingDialog();
        anVar = this.a.g;
        if (anVar != null) {
            anVar2 = this.a.g;
            anVar2.cancel();
        }
    }
}
