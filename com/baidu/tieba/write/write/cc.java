package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class cc implements a.b {
    final /* synthetic */ ca fVt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(ca caVar) {
        this.fVt = caVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        WriteMultiImgsActivity writeMultiImgsActivity;
        com.baidu.tbadk.core.dialog.a aVar2;
        WriteMultiImgsActivity writeMultiImgsActivity2;
        WriteMultiImgsActivity writeMultiImgsActivity3;
        WriteMultiImgsActivity writeMultiImgsActivity4;
        com.baidu.tbadk.core.dialog.a aVar3;
        writeMultiImgsActivity = this.fVt.fVs;
        aVar2 = writeMultiImgsActivity.fVn;
        if (aVar2 != null) {
            writeMultiImgsActivity4 = this.fVt.fVs;
            aVar3 = writeMultiImgsActivity4.fVn;
            aVar3.dismiss();
        }
        writeMultiImgsActivity2 = this.fVt.fVs;
        writeMultiImgsActivity2.setResult(0);
        writeMultiImgsActivity3 = this.fVt.fVs;
        writeMultiImgsActivity3.finish();
    }
}
