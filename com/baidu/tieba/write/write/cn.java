package com.baidu.tieba.write.write;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cn implements DialogInterface.OnCancelListener {
    final /* synthetic */ ck gmI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cn(ck ckVar) {
        this.gmI = ckVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        com.baidu.tieba.write.transmit.model.a aVar;
        com.baidu.tieba.write.transmit.model.a aVar2;
        aVar = this.gmI.gio;
        if (aVar != null) {
            aVar2 = this.gmI.gio;
            aVar2.aBZ();
        }
    }
}
