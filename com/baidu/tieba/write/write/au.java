package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements a.b {
    final /* synthetic */ WriteActivity fea;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(WriteActivity writeActivity) {
        this.fea = writeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        WriteData writeData;
        WriteData writeData2;
        WriteData writeData3;
        aVar.dismiss();
        writeData = this.fea.evE;
        int type = writeData.getType();
        if (type == 0) {
            writeData3 = this.fea.evE;
            com.baidu.tieba.tbadkCore.ae.b(writeData3.getForumId(), (WriteData) null);
        } else if (type == 1) {
            writeData2 = this.fea.evE;
            com.baidu.tieba.tbadkCore.ae.c(writeData2.getThreadId(), (WriteData) null);
        }
        this.fea.finish();
    }
}
