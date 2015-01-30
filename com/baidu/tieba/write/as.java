package com.baidu.tieba.write;

import android.os.Handler;
import android.widget.EditText;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ WriteActivity cgS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(WriteActivity writeActivity) {
        this.cgS = writeActivity;
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
        writeData = this.cgS.bPp;
        editText = this.cgS.bPG;
        writeData.setTitle(editText.getText().toString());
        writeData2 = this.cgS.bPp;
        editText2 = this.cgS.bPK;
        writeData2.setContent(editText2.getText().toString());
        writeData3 = this.cgS.bPp;
        int type = writeData3.getType();
        if (type == 0) {
            writeData6 = this.cgS.bPp;
            String forumId = writeData6.getForumId();
            writeData7 = this.cgS.bPp;
            com.baidu.tieba.tbadkCore.al.a(forumId, writeData7);
        } else if (type == 1) {
            writeData4 = this.cgS.bPp;
            String threadId = writeData4.getThreadId();
            writeData5 = this.cgS.bPp;
            com.baidu.tieba.tbadkCore.al.b(threadId, writeData5);
        }
        this.cgS.showToast(com.baidu.tieba.z.draft_save_success);
        handler = this.cgS.mHandler;
        handler.postDelayed(new at(this), 1000L);
    }
}
