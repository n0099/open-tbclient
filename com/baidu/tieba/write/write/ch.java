package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class ch implements a.b {
    final /* synthetic */ cg feN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ch(cg cgVar) {
        this.feN = cgVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        WriteMultiImgsActivity writeMultiImgsActivity;
        com.baidu.tbadk.core.dialog.a aVar2;
        WriteMultiImgsActivity writeMultiImgsActivity2;
        WriteMultiImgsActivity writeMultiImgsActivity3;
        com.baidu.tbadk.core.dialog.a aVar3;
        writeMultiImgsActivity = this.feN.feM;
        aVar2 = writeMultiImgsActivity.feH;
        if (aVar2 != null) {
            writeMultiImgsActivity3 = this.feN.feM;
            aVar3 = writeMultiImgsActivity3.feH;
            aVar3.dismiss();
        }
        writeMultiImgsActivity2 = this.feN.feM;
        writeMultiImgsActivity2.ben();
    }
}
