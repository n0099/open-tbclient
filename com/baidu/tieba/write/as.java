package com.baidu.tieba.write;

import android.content.DialogInterface;
import android.os.Handler;
import android.widget.EditText;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements DialogInterface.OnClickListener {
    final /* synthetic */ WriteActivity bUm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(WriteActivity writeActivity) {
        this.bUm = writeActivity;
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
        writeData = this.bUm.bpJ;
        editText = this.bUm.bJG;
        writeData.setTitle(editText.getText().toString());
        writeData2 = this.bUm.bpJ;
        editText2 = this.bUm.bJK;
        writeData2.setContent(editText2.getText().toString());
        writeData3 = this.bUm.bpJ;
        int type = writeData3.getType();
        if (type == 0) {
            writeData6 = this.bUm.bpJ;
            String forumId = writeData6.getForumId();
            writeData7 = this.bUm.bpJ;
            com.baidu.tieba.util.l.a(forumId, writeData7);
        } else if (type == 1) {
            writeData4 = this.bUm.bpJ;
            String threadId = writeData4.getThreadId();
            writeData5 = this.bUm.bpJ;
            com.baidu.tieba.util.l.b(threadId, writeData5);
        }
        this.bUm.showToast(com.baidu.tieba.y.draft_save_success);
        handler = this.bUm.mHandler;
        handler.postDelayed(new at(this), 1000L);
    }
}
