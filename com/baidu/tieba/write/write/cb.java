package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class cb implements a.b {
    final /* synthetic */ ca fRn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cb(ca caVar) {
        this.fRn = caVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        WriteMultiImgsActivity writeMultiImgsActivity;
        com.baidu.tbadk.core.dialog.a aVar2;
        WriteMultiImgsActivity writeMultiImgsActivity2;
        WriteMultiImgsActivity writeMultiImgsActivity3;
        com.baidu.tbadk.core.dialog.a aVar3;
        writeMultiImgsActivity = this.fRn.fRm;
        aVar2 = writeMultiImgsActivity.fRh;
        if (aVar2 != null) {
            writeMultiImgsActivity3 = this.fRn.fRm;
            aVar3 = writeMultiImgsActivity3.fRh;
            aVar3.dismiss();
        }
        writeMultiImgsActivity2 = this.fRn.fRm;
        writeMultiImgsActivity2.bpb();
    }
}
