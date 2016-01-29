package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class ca implements a.b {
    final /* synthetic */ bz etX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(bz bzVar) {
        this.etX = bzVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        WriteMultiImgsActivity writeMultiImgsActivity;
        com.baidu.tbadk.core.dialog.a aVar2;
        WriteMultiImgsActivity writeMultiImgsActivity2;
        WriteMultiImgsActivity writeMultiImgsActivity3;
        com.baidu.tbadk.core.dialog.a aVar3;
        writeMultiImgsActivity = this.etX.etW;
        aVar2 = writeMultiImgsActivity.etS;
        if (aVar2 != null) {
            writeMultiImgsActivity3 = this.etX.etW;
            aVar3 = writeMultiImgsActivity3.etS;
            aVar3.dismiss();
        }
        writeMultiImgsActivity2 = this.etX.etW;
        writeMultiImgsActivity2.aVo();
    }
}
