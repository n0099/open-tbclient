package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class cd implements a.b {
    final /* synthetic */ cc fVZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(cc ccVar) {
        this.fVZ = ccVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        WriteMultiImgsActivity writeMultiImgsActivity;
        com.baidu.tbadk.core.dialog.a aVar2;
        WriteMultiImgsActivity writeMultiImgsActivity2;
        WriteMultiImgsActivity writeMultiImgsActivity3;
        com.baidu.tbadk.core.dialog.a aVar3;
        writeMultiImgsActivity = this.fVZ.fVY;
        aVar2 = writeMultiImgsActivity.fVT;
        if (aVar2 != null) {
            writeMultiImgsActivity3 = this.fVZ.fVY;
            aVar3 = writeMultiImgsActivity3.fVT;
            aVar3.dismiss();
        }
        writeMultiImgsActivity2 = this.fVZ.fVY;
        writeMultiImgsActivity2.bpC();
    }
}
