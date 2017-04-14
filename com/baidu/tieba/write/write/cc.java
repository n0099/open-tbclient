package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class cc implements a.b {
    final /* synthetic */ ca fSX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(ca caVar) {
        this.fSX = caVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        WriteMultiImgsActivity writeMultiImgsActivity;
        com.baidu.tbadk.core.dialog.a aVar2;
        WriteMultiImgsActivity writeMultiImgsActivity2;
        WriteMultiImgsActivity writeMultiImgsActivity3;
        WriteMultiImgsActivity writeMultiImgsActivity4;
        com.baidu.tbadk.core.dialog.a aVar3;
        writeMultiImgsActivity = this.fSX.fSW;
        aVar2 = writeMultiImgsActivity.fSR;
        if (aVar2 != null) {
            writeMultiImgsActivity4 = this.fSX.fSW;
            aVar3 = writeMultiImgsActivity4.fSR;
            aVar3.dismiss();
        }
        writeMultiImgsActivity2 = this.fSX.fSW;
        writeMultiImgsActivity2.setResult(0);
        writeMultiImgsActivity3 = this.fSX.fSW;
        writeMultiImgsActivity3.finish();
    }
}
