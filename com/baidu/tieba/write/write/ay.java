package com.baidu.tieba.write.write;

import android.os.Handler;
import android.widget.EditText;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ WriteActivity cCQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(WriteActivity writeActivity) {
        this.cCQ = writeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        WriteData writeData;
        EditText editText;
        WriteData writeData2;
        EditText editText2;
        WriteData writeData3;
        WriteData writeData4;
        WriteData writeData5;
        Handler handler;
        WriteData writeData6;
        WriteData writeData7;
        aVar.dismiss();
        writeData = this.cCQ.cup;
        editText = this.cCQ.cAv;
        writeData.setTitle(editText.getText().toString());
        writeData2 = this.cCQ.cup;
        editText2 = this.cCQ.cAz;
        writeData2.setContent(editText2.getText().toString());
        writeData3 = this.cCQ.cup;
        int type = writeData3.getType();
        if (type == 0) {
            writeData6 = this.cCQ.cup;
            String forumId = writeData6.getForumId();
            writeData7 = this.cCQ.cup;
            com.baidu.tieba.tbadkCore.ao.a(forumId, writeData7);
        } else if (type == 1) {
            writeData4 = this.cCQ.cup;
            String threadId = writeData4.getThreadId();
            writeData5 = this.cCQ.cup;
            com.baidu.tieba.tbadkCore.ao.b(threadId, writeData5);
        }
        this.cCQ.showToast(com.baidu.tieba.t.draft_save_success);
        handler = this.cCQ.mHandler;
        handler.postDelayed(new az(this), 1000L);
    }
}
