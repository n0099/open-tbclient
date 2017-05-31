package com.baidu.tieba.write.write;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class u implements DialogInterface.OnCancelListener {
    final /* synthetic */ WriteActivity gaR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(WriteActivity writeActivity) {
        this.gaR = writeActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        com.baidu.tieba.write.transmit.model.a aVar;
        com.baidu.tieba.write.transmit.model.a aVar2;
        aVar = this.gaR.fXo;
        if (aVar != null) {
            aVar2 = this.gaR.fXo;
            aVar2.aYl();
        }
    }
}
