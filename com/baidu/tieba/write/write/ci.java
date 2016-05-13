package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class ci implements a.b {
    final /* synthetic */ cg feN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ci(cg cgVar) {
        this.feN = cgVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        WriteMultiImgsActivity writeMultiImgsActivity;
        com.baidu.tbadk.core.dialog.a aVar2;
        WriteMultiImgsActivity writeMultiImgsActivity2;
        WriteMultiImgsActivity writeMultiImgsActivity3;
        WriteMultiImgsActivity writeMultiImgsActivity4;
        com.baidu.tbadk.core.dialog.a aVar3;
        writeMultiImgsActivity = this.feN.feM;
        aVar2 = writeMultiImgsActivity.feH;
        if (aVar2 != null) {
            writeMultiImgsActivity4 = this.feN.feM;
            aVar3 = writeMultiImgsActivity4.feH;
            aVar3.dismiss();
        }
        writeMultiImgsActivity2 = this.feN.feM;
        writeMultiImgsActivity2.setResult(0);
        writeMultiImgsActivity3 = this.feN.feM;
        writeMultiImgsActivity3.finish();
    }
}
