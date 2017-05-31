package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class cg implements a.b {
    final /* synthetic */ ce gby;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cg(ce ceVar) {
        this.gby = ceVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        WriteMultiImgsActivity writeMultiImgsActivity;
        com.baidu.tbadk.core.dialog.a aVar2;
        WriteMultiImgsActivity writeMultiImgsActivity2;
        WriteMultiImgsActivity writeMultiImgsActivity3;
        WriteMultiImgsActivity writeMultiImgsActivity4;
        com.baidu.tbadk.core.dialog.a aVar3;
        writeMultiImgsActivity = this.gby.gbx;
        aVar2 = writeMultiImgsActivity.gbs;
        if (aVar2 != null) {
            writeMultiImgsActivity4 = this.gby.gbx;
            aVar3 = writeMultiImgsActivity4.gbs;
            aVar3.dismiss();
        }
        writeMultiImgsActivity2 = this.gby.gbx;
        writeMultiImgsActivity2.setResult(0);
        writeMultiImgsActivity3 = this.gby.gbx;
        writeMultiImgsActivity3.finish();
    }
}
