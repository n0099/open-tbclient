package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class cf implements a.b {
    final /* synthetic */ cd gqa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(cd cdVar) {
        this.gqa = cdVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        WriteMultiImgsActivity writeMultiImgsActivity;
        com.baidu.tbadk.core.dialog.a aVar2;
        WriteMultiImgsActivity writeMultiImgsActivity2;
        WriteMultiImgsActivity writeMultiImgsActivity3;
        WriteMultiImgsActivity writeMultiImgsActivity4;
        com.baidu.tbadk.core.dialog.a aVar3;
        writeMultiImgsActivity = this.gqa.gpZ;
        aVar2 = writeMultiImgsActivity.gpU;
        if (aVar2 != null) {
            writeMultiImgsActivity4 = this.gqa.gpZ;
            aVar3 = writeMultiImgsActivity4.gpU;
            aVar3.dismiss();
        }
        writeMultiImgsActivity2 = this.gqa.gpZ;
        writeMultiImgsActivity2.setResult(0);
        writeMultiImgsActivity3 = this.gqa.gpZ;
        writeMultiImgsActivity3.finish();
    }
}
