package com.baidu.tieba.write;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements DialogInterface.OnCancelListener {
    final /* synthetic */ a gdz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.gdz = aVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        com.baidu.tieba.write.transmit.model.a aVar;
        com.baidu.tieba.likedForum.a aVar2;
        com.baidu.tieba.likedForum.a aVar3;
        com.baidu.tieba.write.transmit.model.a aVar4;
        aVar = this.gdz.gdp;
        if (aVar != null) {
            aVar4 = this.gdz.gdp;
            aVar4.aBZ();
        }
        aVar2 = this.gdz.gdq;
        if (aVar2 != null) {
            aVar3 = this.gdz.gdq;
            aVar3.aBZ();
        }
    }
}
