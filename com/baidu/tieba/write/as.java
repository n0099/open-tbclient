package com.baidu.tieba.write;

import android.content.DialogInterface;
import android.os.Handler;
import android.widget.EditText;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements DialogInterface.OnClickListener {
    final /* synthetic */ WriteActivity cft;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(WriteActivity writeActivity) {
        this.cft = writeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
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
        writeData = this.cft.bNF;
        editText = this.cft.bNW;
        writeData.setTitle(editText.getText().toString());
        writeData2 = this.cft.bNF;
        editText2 = this.cft.bOa;
        writeData2.setContent(editText2.getText().toString());
        writeData3 = this.cft.bNF;
        int type = writeData3.getType();
        if (type == 0) {
            writeData6 = this.cft.bNF;
            String forumId = writeData6.getForumId();
            writeData7 = this.cft.bNF;
            com.baidu.tieba.tbadkCore.al.a(forumId, writeData7);
        } else if (type == 1) {
            writeData4 = this.cft.bNF;
            String threadId = writeData4.getThreadId();
            writeData5 = this.cft.bNF;
            com.baidu.tieba.tbadkCore.al.b(threadId, writeData5);
        }
        this.cft.showToast(com.baidu.tieba.z.draft_save_success);
        handler = this.cft.mHandler;
        handler.postDelayed(new at(this), 1000L);
    }
}
