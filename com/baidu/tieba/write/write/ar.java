package com.baidu.tieba.write.write;

import android.os.Handler;
import android.widget.EditText;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements a.b {
    final /* synthetic */ WriteActivity ddQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(WriteActivity writeActivity) {
        this.ddQ = writeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        WriteData writeData;
        EditText azL;
        WriteData writeData2;
        EditText azK;
        WriteData writeData3;
        WriteData writeData4;
        WriteData writeData5;
        Handler handler;
        WriteData writeData6;
        WriteData writeData7;
        aVar.dismiss();
        writeData = this.ddQ.cTs;
        azL = this.ddQ.azL();
        writeData.setTitle(azL.getText().toString());
        writeData2 = this.ddQ.cTs;
        azK = this.ddQ.azK();
        writeData2.setContent(azK.getText().toString());
        writeData3 = this.ddQ.cTs;
        int type = writeData3.getType();
        if (type == 0) {
            writeData6 = this.ddQ.cTs;
            String forumId = writeData6.getForumId();
            writeData7 = this.ddQ.cTs;
            com.baidu.tieba.tbadkCore.ad.b(forumId, writeData7);
        } else if (type == 1) {
            writeData4 = this.ddQ.cTs;
            String threadId = writeData4.getThreadId();
            writeData5 = this.ddQ.cTs;
            com.baidu.tieba.tbadkCore.ad.c(threadId, writeData5);
        }
        this.ddQ.showToast(i.h.draft_save_success);
        handler = this.ddQ.mHandler;
        handler.postDelayed(new as(this), 1000L);
    }
}
