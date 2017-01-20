package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class cb implements a.b {
    final /* synthetic */ ca fMS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cb(ca caVar) {
        this.fMS = caVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        WriteMultiImgsActivity writeMultiImgsActivity;
        com.baidu.tbadk.core.dialog.a aVar2;
        WriteMultiImgsActivity writeMultiImgsActivity2;
        WriteMultiImgsActivity writeMultiImgsActivity3;
        com.baidu.tbadk.core.dialog.a aVar3;
        writeMultiImgsActivity = this.fMS.fMR;
        aVar2 = writeMultiImgsActivity.fMM;
        if (aVar2 != null) {
            writeMultiImgsActivity3 = this.fMS.fMR;
            aVar3 = writeMultiImgsActivity3.fMM;
            aVar3.dismiss();
        }
        writeMultiImgsActivity2 = this.fMS.fMR;
        writeMultiImgsActivity2.bpn();
    }
}
