package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class cg implements a.b {
    final /* synthetic */ ce fTC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cg(ce ceVar) {
        this.fTC = ceVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        WriteMultiImgsActivity writeMultiImgsActivity;
        com.baidu.tbadk.core.dialog.a aVar2;
        WriteMultiImgsActivity writeMultiImgsActivity2;
        WriteMultiImgsActivity writeMultiImgsActivity3;
        WriteMultiImgsActivity writeMultiImgsActivity4;
        com.baidu.tbadk.core.dialog.a aVar3;
        writeMultiImgsActivity = this.fTC.fTB;
        aVar2 = writeMultiImgsActivity.fTw;
        if (aVar2 != null) {
            writeMultiImgsActivity4 = this.fTC.fTB;
            aVar3 = writeMultiImgsActivity4.fTw;
            aVar3.dismiss();
        }
        writeMultiImgsActivity2 = this.fTC.fTB;
        writeMultiImgsActivity2.setResult(0);
        writeMultiImgsActivity3 = this.fTC.fTB;
        writeMultiImgsActivity3.finish();
    }
}
