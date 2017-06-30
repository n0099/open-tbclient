package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements a.b {
    final /* synthetic */ WriteActivity glP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(WriteActivity writeActivity) {
        this.glP = writeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        WriteData writeData;
        WriteData writeData2;
        WriteData writeData3;
        aVar.dismiss();
        writeData = this.glP.mData;
        int type = writeData.getType();
        if (type == 0) {
            writeData3 = this.glP.mData;
            com.baidu.tieba.tbadkCore.x.b(writeData3.getForumId(), (WriteData) null);
        } else if (type == 1) {
            writeData2 = this.glP.mData;
            com.baidu.tieba.tbadkCore.x.c(writeData2.getThreadId(), (WriteData) null);
        }
        this.glP.finish();
    }
}
