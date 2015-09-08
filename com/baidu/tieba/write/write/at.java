package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements a.b {
    final /* synthetic */ WriteActivity ddQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(WriteActivity writeActivity) {
        this.ddQ = writeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        WriteData writeData;
        WriteData writeData2;
        WriteData writeData3;
        aVar.dismiss();
        writeData = this.ddQ.cTs;
        int type = writeData.getType();
        if (type == 0) {
            writeData3 = this.ddQ.cTs;
            com.baidu.tieba.tbadkCore.ad.b(writeData3.getForumId(), (WriteData) null);
        } else if (type == 1) {
            writeData2 = this.ddQ.cTs;
            com.baidu.tieba.tbadkCore.ad.c(writeData2.getThreadId(), (WriteData) null);
        }
        this.ddQ.finish();
    }
}
