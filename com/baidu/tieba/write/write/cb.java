package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class cb implements a.b {
    final /* synthetic */ ca fVt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cb(ca caVar) {
        this.fVt = caVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        WriteMultiImgsActivity writeMultiImgsActivity;
        com.baidu.tbadk.core.dialog.a aVar2;
        WriteMultiImgsActivity writeMultiImgsActivity2;
        WriteMultiImgsActivity writeMultiImgsActivity3;
        com.baidu.tbadk.core.dialog.a aVar3;
        writeMultiImgsActivity = this.fVt.fVs;
        aVar2 = writeMultiImgsActivity.fVn;
        if (aVar2 != null) {
            writeMultiImgsActivity3 = this.fVt.fVs;
            aVar3 = writeMultiImgsActivity3.fVn;
            aVar3.dismiss();
        }
        writeMultiImgsActivity2 = this.fVt.fVs;
        writeMultiImgsActivity2.bqK();
    }
}
