package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class cd implements a.b {
    final /* synthetic */ cc fKi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(cc ccVar) {
        this.fKi = ccVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        WriteMultiImgsActivity writeMultiImgsActivity;
        com.baidu.tbadk.core.dialog.a aVar2;
        WriteMultiImgsActivity writeMultiImgsActivity2;
        WriteMultiImgsActivity writeMultiImgsActivity3;
        com.baidu.tbadk.core.dialog.a aVar3;
        writeMultiImgsActivity = this.fKi.fKh;
        aVar2 = writeMultiImgsActivity.fKc;
        if (aVar2 != null) {
            writeMultiImgsActivity3 = this.fKi.fKh;
            aVar3 = writeMultiImgsActivity3.fKc;
            aVar3.dismiss();
        }
        writeMultiImgsActivity2 = this.fKi.fKh;
        writeMultiImgsActivity2.bmI();
    }
}
