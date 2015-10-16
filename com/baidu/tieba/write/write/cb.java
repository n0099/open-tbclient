package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class cb implements a.b {
    final /* synthetic */ ca dqN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cb(ca caVar) {
        this.dqN = caVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        WriteMultiImgsActivity writeMultiImgsActivity;
        com.baidu.tbadk.core.dialog.a aVar2;
        WriteMultiImgsActivity writeMultiImgsActivity2;
        WriteMultiImgsActivity writeMultiImgsActivity3;
        com.baidu.tbadk.core.dialog.a aVar3;
        writeMultiImgsActivity = this.dqN.dqM;
        aVar2 = writeMultiImgsActivity.dqI;
        if (aVar2 != null) {
            writeMultiImgsActivity3 = this.dqN.dqM;
            aVar3 = writeMultiImgsActivity3.dqI;
            aVar3.dismiss();
        }
        writeMultiImgsActivity2 = this.dqN.dqM;
        writeMultiImgsActivity2.aDM();
    }
}
