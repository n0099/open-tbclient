package com.baidu.tieba.write;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class av implements DialogInterface.OnCancelListener {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.a.destroyWaitingDialog();
        this.a.a();
    }
}
