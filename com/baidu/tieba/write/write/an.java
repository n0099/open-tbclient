package com.baidu.tieba.write.write;

import android.os.Handler;
import android.widget.EditText;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements a.b {
    final /* synthetic */ WriteActivity fSq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(WriteActivity writeActivity) {
        this.fSq = writeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        WriteData writeData;
        EditText bps;
        WriteData writeData2;
        EditText bpr;
        WriteData writeData3;
        WriteData writeData4;
        WriteData writeData5;
        Handler handler;
        WriteData writeData6;
        WriteData writeData7;
        aVar.dismiss();
        writeData = this.fSq.mData;
        bps = this.fSq.bps();
        writeData.setTitle(bps.getText().toString());
        writeData2 = this.fSq.mData;
        bpr = this.fSq.bpr();
        writeData2.setContent(bpr.getText().toString());
        writeData3 = this.fSq.mData;
        int type = writeData3.getType();
        if (type == 0) {
            writeData6 = this.fSq.mData;
            String forumId = writeData6.getForumId();
            writeData7 = this.fSq.mData;
            com.baidu.tieba.tbadkCore.z.b(forumId, writeData7);
        } else if (type == 1) {
            writeData4 = this.fSq.mData;
            String threadId = writeData4.getThreadId();
            writeData5 = this.fSq.mData;
            com.baidu.tieba.tbadkCore.z.c(threadId, writeData5);
        }
        this.fSq.showToast(w.l.draft_save_success);
        handler = this.fSq.mHandler;
        handler.postDelayed(new ao(this), 1000L);
    }
}
