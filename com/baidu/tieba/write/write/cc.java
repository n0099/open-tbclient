package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class cc implements a.b {
    final /* synthetic */ cb fEy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(cb cbVar) {
        this.fEy = cbVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        WriteMultiImgsActivity writeMultiImgsActivity;
        com.baidu.tbadk.core.dialog.a aVar2;
        WriteMultiImgsActivity writeMultiImgsActivity2;
        WriteMultiImgsActivity writeMultiImgsActivity3;
        com.baidu.tbadk.core.dialog.a aVar3;
        writeMultiImgsActivity = this.fEy.fEx;
        aVar2 = writeMultiImgsActivity.fEs;
        if (aVar2 != null) {
            writeMultiImgsActivity3 = this.fEy.fEx;
            aVar3 = writeMultiImgsActivity3.fEs;
            aVar3.dismiss();
        }
        writeMultiImgsActivity2 = this.fEy.fEx;
        writeMultiImgsActivity2.bnP();
    }
}
