package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class ce implements a.b {
    final /* synthetic */ cc gge;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(cc ccVar) {
        this.gge = ccVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        WriteMultiImgsActivity writeMultiImgsActivity;
        com.baidu.tbadk.core.dialog.a aVar2;
        WriteMultiImgsActivity writeMultiImgsActivity2;
        WriteMultiImgsActivity writeMultiImgsActivity3;
        WriteMultiImgsActivity writeMultiImgsActivity4;
        com.baidu.tbadk.core.dialog.a aVar3;
        writeMultiImgsActivity = this.gge.ggd;
        aVar2 = writeMultiImgsActivity.gfY;
        if (aVar2 != null) {
            writeMultiImgsActivity4 = this.gge.ggd;
            aVar3 = writeMultiImgsActivity4.gfY;
            aVar3.dismiss();
        }
        writeMultiImgsActivity2 = this.gge.ggd;
        writeMultiImgsActivity2.setResult(0);
        writeMultiImgsActivity3 = this.gge.ggd;
        writeMultiImgsActivity3.finish();
    }
}
