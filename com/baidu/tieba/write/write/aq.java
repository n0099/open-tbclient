package com.baidu.tieba.write.write;

import android.os.Handler;
import android.widget.EditText;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements a.b {
    final /* synthetic */ WriteActivity ghD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(WriteActivity writeActivity) {
        this.ghD = writeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        WriteData writeData;
        EditText bug;
        WriteData writeData2;
        EditText buf;
        WriteData writeData3;
        WriteData writeData4;
        WriteData writeData5;
        Handler handler;
        WriteData writeData6;
        WriteData writeData7;
        aVar.dismiss();
        writeData = this.ghD.flk;
        bug = this.ghD.bug();
        writeData.setTitle(bug.getText().toString());
        writeData2 = this.ghD.flk;
        buf = this.ghD.buf();
        writeData2.setContent(buf.getText().toString());
        writeData3 = this.ghD.flk;
        int type = writeData3.getType();
        if (type == 0) {
            writeData6 = this.ghD.flk;
            String forumId = writeData6.getForumId();
            writeData7 = this.ghD.flk;
            com.baidu.tieba.tbadkCore.ae.b(forumId, writeData7);
        } else if (type == 1) {
            writeData4 = this.ghD.flk;
            String threadId = writeData4.getThreadId();
            writeData5 = this.ghD.flk;
            com.baidu.tieba.tbadkCore.ae.c(threadId, writeData5);
        }
        this.ghD.showToast(r.j.draft_save_success);
        handler = this.ghD.mHandler;
        handler.postDelayed(new ar(this), 1000L);
    }
}
