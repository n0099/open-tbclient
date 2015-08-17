package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements a.b {
    final /* synthetic */ WriteActivity cUM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(WriteActivity writeActivity) {
        this.cUM = writeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        WriteData writeData;
        WriteData writeData2;
        WriteData writeData3;
        aVar.dismiss();
        writeData = this.cUM.cKS;
        int type = writeData.getType();
        if (type == 0) {
            writeData3 = this.cUM.cKS;
            com.baidu.tieba.tbadkCore.ac.b(writeData3.getForumId(), (WriteData) null);
        } else if (type == 1) {
            writeData2 = this.cUM.cKS;
            com.baidu.tieba.tbadkCore.ac.c(writeData2.getThreadId(), (WriteData) null);
        }
        this.cUM.finish();
    }
}
