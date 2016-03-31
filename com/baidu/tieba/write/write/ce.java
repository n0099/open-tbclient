package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class ce implements a.b {
    final /* synthetic */ cd eNO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(cd cdVar) {
        this.eNO = cdVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        WriteMultiImgsActivity writeMultiImgsActivity;
        com.baidu.tbadk.core.dialog.a aVar2;
        WriteMultiImgsActivity writeMultiImgsActivity2;
        WriteMultiImgsActivity writeMultiImgsActivity3;
        com.baidu.tbadk.core.dialog.a aVar3;
        writeMultiImgsActivity = this.eNO.eNN;
        aVar2 = writeMultiImgsActivity.eNJ;
        if (aVar2 != null) {
            writeMultiImgsActivity3 = this.eNO.eNN;
            aVar3 = writeMultiImgsActivity3.eNJ;
            aVar3.dismiss();
        }
        writeMultiImgsActivity2 = this.eNO.eNN;
        writeMultiImgsActivity2.bbO();
    }
}
