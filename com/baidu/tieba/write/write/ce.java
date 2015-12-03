package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class ce implements a.b {
    final /* synthetic */ cc dRK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(cc ccVar) {
        this.dRK = ccVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        WriteMultiImgsActivity writeMultiImgsActivity;
        com.baidu.tbadk.core.dialog.a aVar2;
        WriteMultiImgsActivity writeMultiImgsActivity2;
        WriteMultiImgsActivity writeMultiImgsActivity3;
        WriteMultiImgsActivity writeMultiImgsActivity4;
        com.baidu.tbadk.core.dialog.a aVar3;
        writeMultiImgsActivity = this.dRK.dRJ;
        aVar2 = writeMultiImgsActivity.dRF;
        if (aVar2 != null) {
            writeMultiImgsActivity4 = this.dRK.dRJ;
            aVar3 = writeMultiImgsActivity4.dRF;
            aVar3.dismiss();
        }
        writeMultiImgsActivity2 = this.dRK.dRJ;
        writeMultiImgsActivity2.setResult(0);
        writeMultiImgsActivity3 = this.dRK.dRJ;
        writeMultiImgsActivity3.finish();
    }
}
