package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class ce implements a.b {
    final /* synthetic */ cd gqa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(cd cdVar) {
        this.gqa = cdVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        WriteMultiImgsActivity writeMultiImgsActivity;
        com.baidu.tbadk.core.dialog.a aVar2;
        WriteMultiImgsActivity writeMultiImgsActivity2;
        WriteMultiImgsActivity writeMultiImgsActivity3;
        com.baidu.tbadk.core.dialog.a aVar3;
        writeMultiImgsActivity = this.gqa.gpZ;
        aVar2 = writeMultiImgsActivity.gpU;
        if (aVar2 != null) {
            writeMultiImgsActivity3 = this.gqa.gpZ;
            aVar3 = writeMultiImgsActivity3.gpU;
            aVar3.dismiss();
        }
        writeMultiImgsActivity2 = this.gqa.gpZ;
        writeMultiImgsActivity2.bwQ();
    }
}
