package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements a.b {
    final /* synthetic */ WriteActivity dYD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(WriteActivity writeActivity) {
        this.dYD = writeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        WriteData writeData;
        WriteData writeData2;
        WriteData writeData3;
        aVar.dismiss();
        writeData = this.dYD.dJy;
        int type = writeData.getType();
        if (type == 0) {
            writeData3 = this.dYD.dJy;
            com.baidu.tieba.tbadkCore.ae.b(writeData3.getForumId(), (WriteData) null);
        } else if (type == 1) {
            writeData2 = this.dYD.dJy;
            com.baidu.tieba.tbadkCore.ae.c(writeData2.getThreadId(), (WriteData) null);
        }
        this.dYD.finish();
    }
}
