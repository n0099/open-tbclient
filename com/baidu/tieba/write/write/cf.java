package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class cf implements a.b {
    final /* synthetic */ ce fTC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(ce ceVar) {
        this.fTC = ceVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        WriteMultiImgsActivity writeMultiImgsActivity;
        com.baidu.tbadk.core.dialog.a aVar2;
        WriteMultiImgsActivity writeMultiImgsActivity2;
        WriteMultiImgsActivity writeMultiImgsActivity3;
        com.baidu.tbadk.core.dialog.a aVar3;
        writeMultiImgsActivity = this.fTC.fTB;
        aVar2 = writeMultiImgsActivity.fTw;
        if (aVar2 != null) {
            writeMultiImgsActivity3 = this.fTC.fTB;
            aVar3 = writeMultiImgsActivity3.fTw;
            aVar3.dismiss();
        }
        writeMultiImgsActivity2 = this.fTC.fTB;
        writeMultiImgsActivity2.boO();
    }
}
