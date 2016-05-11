package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class ch implements a.b {
    final /* synthetic */ cg feO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ch(cg cgVar) {
        this.feO = cgVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        WriteMultiImgsActivity writeMultiImgsActivity;
        com.baidu.tbadk.core.dialog.a aVar2;
        WriteMultiImgsActivity writeMultiImgsActivity2;
        WriteMultiImgsActivity writeMultiImgsActivity3;
        com.baidu.tbadk.core.dialog.a aVar3;
        writeMultiImgsActivity = this.feO.feN;
        aVar2 = writeMultiImgsActivity.feI;
        if (aVar2 != null) {
            writeMultiImgsActivity3 = this.feO.feN;
            aVar3 = writeMultiImgsActivity3.feI;
            aVar3.dismiss();
        }
        writeMultiImgsActivity2 = this.feO.feN;
        writeMultiImgsActivity2.beg();
    }
}
