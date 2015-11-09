package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class ce implements a.b {
    final /* synthetic */ cc dsF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(cc ccVar) {
        this.dsF = ccVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        WriteMultiImgsActivity writeMultiImgsActivity;
        com.baidu.tbadk.core.dialog.a aVar2;
        WriteMultiImgsActivity writeMultiImgsActivity2;
        WriteMultiImgsActivity writeMultiImgsActivity3;
        WriteMultiImgsActivity writeMultiImgsActivity4;
        com.baidu.tbadk.core.dialog.a aVar3;
        writeMultiImgsActivity = this.dsF.dsE;
        aVar2 = writeMultiImgsActivity.dsA;
        if (aVar2 != null) {
            writeMultiImgsActivity4 = this.dsF.dsE;
            aVar3 = writeMultiImgsActivity4.dsA;
            aVar3.dismiss();
        }
        writeMultiImgsActivity2 = this.dsF.dsE;
        writeMultiImgsActivity2.setResult(0);
        writeMultiImgsActivity3 = this.dsF.dsE;
        writeMultiImgsActivity3.finish();
    }
}
