package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class cb implements a.b {
    final /* synthetic */ ca fSX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cb(ca caVar) {
        this.fSX = caVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        WriteMultiImgsActivity writeMultiImgsActivity;
        com.baidu.tbadk.core.dialog.a aVar2;
        WriteMultiImgsActivity writeMultiImgsActivity2;
        WriteMultiImgsActivity writeMultiImgsActivity3;
        com.baidu.tbadk.core.dialog.a aVar3;
        writeMultiImgsActivity = this.fSX.fSW;
        aVar2 = writeMultiImgsActivity.fSR;
        if (aVar2 != null) {
            writeMultiImgsActivity3 = this.fSX.fSW;
            aVar3 = writeMultiImgsActivity3.fSR;
            aVar3.dismiss();
        }
        writeMultiImgsActivity2 = this.fSX.fSW;
        writeMultiImgsActivity2.bpJ();
    }
}
