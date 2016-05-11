package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class ci implements a.b {
    final /* synthetic */ cg feO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ci(cg cgVar) {
        this.feO = cgVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        WriteMultiImgsActivity writeMultiImgsActivity;
        com.baidu.tbadk.core.dialog.a aVar2;
        WriteMultiImgsActivity writeMultiImgsActivity2;
        WriteMultiImgsActivity writeMultiImgsActivity3;
        WriteMultiImgsActivity writeMultiImgsActivity4;
        com.baidu.tbadk.core.dialog.a aVar3;
        writeMultiImgsActivity = this.feO.feN;
        aVar2 = writeMultiImgsActivity.feI;
        if (aVar2 != null) {
            writeMultiImgsActivity4 = this.feO.feN;
            aVar3 = writeMultiImgsActivity4.feI;
            aVar3.dismiss();
        }
        writeMultiImgsActivity2 = this.feO.feN;
        writeMultiImgsActivity2.setResult(0);
        writeMultiImgsActivity3 = this.feO.feN;
        writeMultiImgsActivity3.finish();
    }
}
