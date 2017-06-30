package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class cd implements a.b {
    final /* synthetic */ cc gmw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(cc ccVar) {
        this.gmw = ccVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        WriteMultiImgsActivity writeMultiImgsActivity;
        com.baidu.tbadk.core.dialog.a aVar2;
        WriteMultiImgsActivity writeMultiImgsActivity2;
        WriteMultiImgsActivity writeMultiImgsActivity3;
        com.baidu.tbadk.core.dialog.a aVar3;
        writeMultiImgsActivity = this.gmw.gmv;
        aVar2 = writeMultiImgsActivity.gmq;
        if (aVar2 != null) {
            writeMultiImgsActivity3 = this.gmw.gmv;
            aVar3 = writeMultiImgsActivity3.gmq;
            aVar3.dismiss();
        }
        writeMultiImgsActivity2 = this.gmw.gmv;
        writeMultiImgsActivity2.buM();
    }
}
