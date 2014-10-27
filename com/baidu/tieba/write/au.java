package com.baidu.tieba.write;

import android.content.DialogInterface;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements DialogInterface.OnClickListener {
    final /* synthetic */ WriteActivity bTX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(WriteActivity writeActivity) {
        this.bTX = writeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        WriteData writeData;
        WriteData writeData2;
        WriteData writeData3;
        writeData = this.bTX.bpv;
        int type = writeData.getType();
        if (type == 0) {
            writeData3 = this.bTX.bpv;
            com.baidu.tieba.util.l.a(writeData3.getForumId(), (WriteData) null);
        } else if (type == 1) {
            writeData2 = this.bTX.bpv;
            com.baidu.tieba.util.l.b(writeData2.getThreadId(), (WriteData) null);
        }
        this.bTX.finish();
    }
}
