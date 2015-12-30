package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class cd implements a.b {
    final /* synthetic */ cc dZi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(cc ccVar) {
        this.dZi = ccVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        WriteMultiImgsActivity writeMultiImgsActivity;
        com.baidu.tbadk.core.dialog.a aVar2;
        WriteMultiImgsActivity writeMultiImgsActivity2;
        WriteMultiImgsActivity writeMultiImgsActivity3;
        com.baidu.tbadk.core.dialog.a aVar3;
        writeMultiImgsActivity = this.dZi.dZh;
        aVar2 = writeMultiImgsActivity.dZd;
        if (aVar2 != null) {
            writeMultiImgsActivity3 = this.dZi.dZh;
            aVar3 = writeMultiImgsActivity3.dZd;
            aVar3.dismiss();
        }
        writeMultiImgsActivity2 = this.dZi.dZh;
        writeMultiImgsActivity2.aMu();
    }
}
