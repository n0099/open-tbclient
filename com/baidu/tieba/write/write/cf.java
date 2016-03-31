package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class cf implements a.b {
    final /* synthetic */ cd eNO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(cd cdVar) {
        this.eNO = cdVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        WriteMultiImgsActivity writeMultiImgsActivity;
        com.baidu.tbadk.core.dialog.a aVar2;
        WriteMultiImgsActivity writeMultiImgsActivity2;
        WriteMultiImgsActivity writeMultiImgsActivity3;
        WriteMultiImgsActivity writeMultiImgsActivity4;
        com.baidu.tbadk.core.dialog.a aVar3;
        writeMultiImgsActivity = this.eNO.eNN;
        aVar2 = writeMultiImgsActivity.eNJ;
        if (aVar2 != null) {
            writeMultiImgsActivity4 = this.eNO.eNN;
            aVar3 = writeMultiImgsActivity4.eNJ;
            aVar3.dismiss();
        }
        writeMultiImgsActivity2 = this.eNO.eNN;
        writeMultiImgsActivity2.setResult(0);
        writeMultiImgsActivity3 = this.eNO.eNN;
        writeMultiImgsActivity3.finish();
    }
}
