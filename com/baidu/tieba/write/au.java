package com.baidu.tieba.write;

import android.content.DialogInterface;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements DialogInterface.OnClickListener {
    final /* synthetic */ WriteActivity cft;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(WriteActivity writeActivity) {
        this.cft = writeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        WriteData writeData;
        WriteData writeData2;
        WriteData writeData3;
        writeData = this.cft.bNF;
        int type = writeData.getType();
        if (type == 0) {
            writeData3 = this.cft.bNF;
            com.baidu.tieba.tbadkCore.al.a(writeData3.getForumId(), (WriteData) null);
        } else if (type == 1) {
            writeData2 = this.cft.bNF;
            com.baidu.tieba.tbadkCore.al.b(writeData2.getThreadId(), (WriteData) null);
        }
        this.cft.finish();
    }
}
