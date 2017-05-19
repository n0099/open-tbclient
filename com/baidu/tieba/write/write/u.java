package com.baidu.tieba.write.write;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class u implements DialogInterface.OnCancelListener {
    final /* synthetic */ WriteActivity fSV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(WriteActivity writeActivity) {
        this.fSV = writeActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        com.baidu.tieba.write.transmit.model.a aVar;
        com.baidu.tieba.write.transmit.model.a aVar2;
        aVar = this.fSV.fPs;
        if (aVar != null) {
            aVar2 = this.fSV.fPs;
            aVar2.aWS();
        }
    }
}
