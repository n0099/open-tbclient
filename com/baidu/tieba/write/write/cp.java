package com.baidu.tieba.write.write;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cp implements DialogInterface.OnCancelListener {
    final /* synthetic */ cm gbK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cp(cm cmVar) {
        this.gbK = cmVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        com.baidu.tieba.write.transmit.model.a aVar;
        com.baidu.tieba.write.transmit.model.a aVar2;
        aVar = this.gbK.fXo;
        if (aVar != null) {
            aVar2 = this.gbK.fXo;
            aVar2.aYl();
        }
    }
}
