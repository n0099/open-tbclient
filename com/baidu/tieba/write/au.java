package com.baidu.tieba.write;

import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ WriteActivity cgS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(WriteActivity writeActivity) {
        this.cgS = writeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        WriteData writeData;
        WriteData writeData2;
        WriteData writeData3;
        aVar.dismiss();
        writeData = this.cgS.bPp;
        int type = writeData.getType();
        if (type == 0) {
            writeData3 = this.cgS.bPp;
            com.baidu.tieba.tbadkCore.al.a(writeData3.getForumId(), (WriteData) null);
        } else if (type == 1) {
            writeData2 = this.cgS.bPp;
            com.baidu.tieba.tbadkCore.al.b(writeData2.getThreadId(), (WriteData) null);
        }
        this.cgS.finish();
    }
}
