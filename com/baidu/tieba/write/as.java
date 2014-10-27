package com.baidu.tieba.write;

import android.content.DialogInterface;
import android.os.Handler;
import android.widget.EditText;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements DialogInterface.OnClickListener {
    final /* synthetic */ WriteActivity bTX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(WriteActivity writeActivity) {
        this.bTX = writeActivity;
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
        writeData = this.bTX.bpv;
        editText = this.bTX.bJr;
        writeData.setTitle(editText.getText().toString());
        writeData2 = this.bTX.bpv;
        editText2 = this.bTX.bJv;
        writeData2.setContent(editText2.getText().toString());
        writeData3 = this.bTX.bpv;
        int type = writeData3.getType();
        if (type == 0) {
            writeData6 = this.bTX.bpv;
            String forumId = writeData6.getForumId();
            writeData7 = this.bTX.bpv;
            com.baidu.tieba.util.l.a(forumId, writeData7);
        } else if (type == 1) {
            writeData4 = this.bTX.bpv;
            String threadId = writeData4.getThreadId();
            writeData5 = this.bTX.bpv;
            com.baidu.tieba.util.l.b(threadId, writeData5);
        }
        this.bTX.showToast(com.baidu.tieba.y.draft_save_success);
        handler = this.bTX.mHandler;
        handler.postDelayed(new at(this), 1000L);
    }
}
