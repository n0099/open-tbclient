package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements a.b {
    final /* synthetic */ WriteActivity gaR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(WriteActivity writeActivity) {
        this.gaR = writeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        WriteData writeData;
        WriteData writeData2;
        WriteData writeData3;
        aVar.dismiss();
        writeData = this.gaR.mData;
        int type = writeData.getType();
        if (type == 0) {
            writeData3 = this.gaR.mData;
            com.baidu.tieba.tbadkCore.x.b(writeData3.getForumId(), (WriteData) null);
        } else if (type == 1) {
            writeData2 = this.gaR.mData;
            com.baidu.tieba.tbadkCore.x.c(writeData2.getThreadId(), (WriteData) null);
        }
        this.gaR.finish();
    }
}
