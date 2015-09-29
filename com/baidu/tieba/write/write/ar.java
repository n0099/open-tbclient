package com.baidu.tieba.write.write;

import android.os.Handler;
import android.widget.EditText;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements a.b {
    final /* synthetic */ WriteActivity dpI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(WriteActivity writeActivity) {
        this.dpI = writeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        WriteData writeData;
        EditText aDn;
        WriteData writeData2;
        EditText aDm;
        WriteData writeData3;
        WriteData writeData4;
        WriteData writeData5;
        Handler handler;
        WriteData writeData6;
        WriteData writeData7;
        aVar.dismiss();
        writeData = this.dpI.daX;
        aDn = this.dpI.aDn();
        writeData.setTitle(aDn.getText().toString());
        writeData2 = this.dpI.daX;
        aDm = this.dpI.aDm();
        writeData2.setContent(aDm.getText().toString());
        writeData3 = this.dpI.daX;
        int type = writeData3.getType();
        if (type == 0) {
            writeData6 = this.dpI.daX;
            String forumId = writeData6.getForumId();
            writeData7 = this.dpI.daX;
            com.baidu.tieba.tbadkCore.ad.b(forumId, writeData7);
        } else if (type == 1) {
            writeData4 = this.dpI.daX;
            String threadId = writeData4.getThreadId();
            writeData5 = this.dpI.daX;
            com.baidu.tieba.tbadkCore.ad.c(threadId, writeData5);
        }
        this.dpI.showToast(i.h.draft_save_success);
        handler = this.dpI.mHandler;
        handler.postDelayed(new as(this), 1000L);
    }
}
