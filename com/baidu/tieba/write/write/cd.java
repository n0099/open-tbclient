package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class cd implements a.b {
    final /* synthetic */ cc dsF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(cc ccVar) {
        this.dsF = ccVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        WriteMultiImgsActivity writeMultiImgsActivity;
        com.baidu.tbadk.core.dialog.a aVar2;
        WriteMultiImgsActivity writeMultiImgsActivity2;
        WriteMultiImgsActivity writeMultiImgsActivity3;
        com.baidu.tbadk.core.dialog.a aVar3;
        writeMultiImgsActivity = this.dsF.dsE;
        aVar2 = writeMultiImgsActivity.dsA;
        if (aVar2 != null) {
            writeMultiImgsActivity3 = this.dsF.dsE;
            aVar3 = writeMultiImgsActivity3.dsA;
            aVar3.dismiss();
        }
        writeMultiImgsActivity2 = this.dsF.dsE;
        writeMultiImgsActivity2.aEC();
    }
}
