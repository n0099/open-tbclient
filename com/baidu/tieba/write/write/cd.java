package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class cd implements a.b {
    final /* synthetic */ cc gip;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(cc ccVar) {
        this.gip = ccVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        WriteMultiImgsActivity writeMultiImgsActivity;
        com.baidu.tbadk.core.dialog.a aVar2;
        WriteMultiImgsActivity writeMultiImgsActivity2;
        WriteMultiImgsActivity writeMultiImgsActivity3;
        com.baidu.tbadk.core.dialog.a aVar3;
        writeMultiImgsActivity = this.gip.gio;
        aVar2 = writeMultiImgsActivity.gij;
        if (aVar2 != null) {
            writeMultiImgsActivity3 = this.gip.gio;
            aVar3 = writeMultiImgsActivity3.gij;
            aVar3.dismiss();
        }
        writeMultiImgsActivity2 = this.gip.gio;
        writeMultiImgsActivity2.bux();
    }
}
