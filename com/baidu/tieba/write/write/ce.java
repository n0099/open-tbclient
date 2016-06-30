package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class ce implements a.b {
    final /* synthetic */ cc fKi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(cc ccVar) {
        this.fKi = ccVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        WriteMultiImgsActivity writeMultiImgsActivity;
        com.baidu.tbadk.core.dialog.a aVar2;
        WriteMultiImgsActivity writeMultiImgsActivity2;
        WriteMultiImgsActivity writeMultiImgsActivity3;
        WriteMultiImgsActivity writeMultiImgsActivity4;
        com.baidu.tbadk.core.dialog.a aVar3;
        writeMultiImgsActivity = this.fKi.fKh;
        aVar2 = writeMultiImgsActivity.fKc;
        if (aVar2 != null) {
            writeMultiImgsActivity4 = this.fKi.fKh;
            aVar3 = writeMultiImgsActivity4.fKc;
            aVar3.dismiss();
        }
        writeMultiImgsActivity2 = this.fKi.fKh;
        writeMultiImgsActivity2.setResult(0);
        writeMultiImgsActivity3 = this.fKi.fKh;
        writeMultiImgsActivity3.finish();
    }
}
