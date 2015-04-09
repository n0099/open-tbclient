package com.baidu.tieba.write.write;

import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ WriteActivity cyx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(WriteActivity writeActivity) {
        this.cyx = writeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        WriteData writeData;
        WriteData writeData2;
        WriteData writeData3;
        aVar.dismiss();
        writeData = this.cyx.cqk;
        int type = writeData.getType();
        if (type == 0) {
            writeData3 = this.cyx.cqk;
            com.baidu.tieba.tbadkCore.ao.a(writeData3.getForumId(), (WriteData) null);
        } else if (type == 1) {
            writeData2 = this.cyx.cqk;
            com.baidu.tieba.tbadkCore.ao.b(writeData2.getThreadId(), (WriteData) null);
        }
        this.cyx.finish();
    }
}
