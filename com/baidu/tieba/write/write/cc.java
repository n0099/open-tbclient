package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class cc implements a.b {
    final /* synthetic */ ca dqN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(ca caVar) {
        this.dqN = caVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        WriteMultiImgsActivity writeMultiImgsActivity;
        com.baidu.tbadk.core.dialog.a aVar2;
        WriteMultiImgsActivity writeMultiImgsActivity2;
        WriteMultiImgsActivity writeMultiImgsActivity3;
        WriteMultiImgsActivity writeMultiImgsActivity4;
        com.baidu.tbadk.core.dialog.a aVar3;
        writeMultiImgsActivity = this.dqN.dqM;
        aVar2 = writeMultiImgsActivity.dqI;
        if (aVar2 != null) {
            writeMultiImgsActivity4 = this.dqN.dqM;
            aVar3 = writeMultiImgsActivity4.dqI;
            aVar3.dismiss();
        }
        writeMultiImgsActivity2 = this.dqN.dqM;
        writeMultiImgsActivity2.setResult(0);
        writeMultiImgsActivity3 = this.dqN.dqM;
        writeMultiImgsActivity3.finish();
    }
}
