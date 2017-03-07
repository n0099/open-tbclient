package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements a.b {
    final /* synthetic */ WriteActivity fQG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(WriteActivity writeActivity) {
        this.fQG = writeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        WriteData writeData;
        WriteData writeData2;
        WriteData writeData3;
        aVar.dismiss();
        writeData = this.fQG.mData;
        int type = writeData.getType();
        if (type == 0) {
            writeData3 = this.fQG.mData;
            com.baidu.tieba.tbadkCore.z.b(writeData3.getForumId(), (WriteData) null);
        } else if (type == 1) {
            writeData2 = this.fQG.mData;
            com.baidu.tieba.tbadkCore.z.c(writeData2.getThreadId(), (WriteData) null);
        }
        this.fQG.finish();
    }
}
