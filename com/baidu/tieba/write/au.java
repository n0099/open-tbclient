package com.baidu.tieba.write;

import android.content.DialogInterface;
/* loaded from: classes.dex */
final class au implements DialogInterface.OnCancelListener {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        com.baidu.tieba.model.ar arVar;
        com.baidu.tieba.model.ar arVar2;
        this.a.DeinitWaitingDialog();
        arVar = this.a.E;
        if (arVar != null) {
            arVar2 = this.a.E;
            arVar2.cancelLoadData();
        }
    }
}
