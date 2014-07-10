package com.baidu.tieba.write;

import android.content.DialogInterface;
import android.os.Handler;
import android.widget.EditText;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements DialogInterface.OnClickListener {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(WriteActivity writeActivity) {
        this.a = writeActivity;
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
        writeData = this.a.a;
        editText = this.a.e;
        writeData.setTitle(editText.getText().toString());
        writeData2 = this.a.a;
        editText2 = this.a.h;
        writeData2.setContent(editText2.getText().toString());
        writeData3 = this.a.a;
        int type = writeData3.getType();
        if (type == 0) {
            writeData6 = this.a.a;
            String forumId = writeData6.getForumId();
            writeData7 = this.a.a;
            com.baidu.tieba.util.m.a(forumId, writeData7);
        } else if (type == 1) {
            writeData4 = this.a.a;
            String threadId = writeData4.getThreadId();
            writeData5 = this.a.a;
            com.baidu.tieba.util.m.b(threadId, writeData5);
        }
        this.a.showToast(com.baidu.tieba.y.draft_save_success);
        handler = this.a.t;
        handler.postDelayed(new ak(this), 1000L);
    }
}
