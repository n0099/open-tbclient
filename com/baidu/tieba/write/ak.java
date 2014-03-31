package com.baidu.tieba.write;

import android.content.DialogInterface;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
final class ak implements DialogInterface.OnClickListener {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        WriteData writeData;
        WriteData writeData2;
        WriteData writeData3;
        writeData = this.a.a;
        int type = writeData.getType();
        if (type == 0) {
            writeData3 = this.a.a;
            com.baidu.tieba.util.m.a(writeData3.getForumId(), (WriteData) null);
        } else if (type == 1) {
            writeData2 = this.a.a;
            com.baidu.tieba.util.m.b(writeData2.getThreadId(), (WriteData) null);
        }
        this.a.finish();
    }
}
