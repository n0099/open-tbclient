package com.baidu.tieba.write.write;

import android.os.Handler;
import android.widget.EditText;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements a.b {
    final /* synthetic */ WriteActivity fDQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(WriteActivity writeActivity) {
        this.fDQ = writeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        WriteData writeData;
        EditText bnx;
        WriteData writeData2;
        EditText bnw;
        WriteData writeData3;
        WriteData writeData4;
        WriteData writeData5;
        Handler handler;
        WriteData writeData6;
        WriteData writeData7;
        aVar.dismiss();
        writeData = this.fDQ.eWm;
        bnx = this.fDQ.bnx();
        writeData.setTitle(bnx.getText().toString());
        writeData2 = this.fDQ.eWm;
        bnw = this.fDQ.bnw();
        writeData2.setContent(bnw.getText().toString());
        writeData3 = this.fDQ.eWm;
        int type = writeData3.getType();
        if (type == 0) {
            writeData6 = this.fDQ.eWm;
            String forumId = writeData6.getForumId();
            writeData7 = this.fDQ.eWm;
            com.baidu.tieba.tbadkCore.ac.b(forumId, writeData7);
        } else if (type == 1) {
            writeData4 = this.fDQ.eWm;
            String threadId = writeData4.getThreadId();
            writeData5 = this.fDQ.eWm;
            com.baidu.tieba.tbadkCore.ac.c(threadId, writeData5);
        }
        this.fDQ.showToast(r.j.draft_save_success);
        handler = this.fDQ.mHandler;
        handler.postDelayed(new aq(this), 1000L);
    }
}
