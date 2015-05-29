package com.baidu.tieba.write.write;

import android.os.Handler;
import android.widget.EditText;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ WriteActivity cCP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(WriteActivity writeActivity) {
        this.cCP = writeActivity;
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
        writeData = this.cCP.cuo;
        editText = this.cCP.cAu;
        writeData.setTitle(editText.getText().toString());
        writeData2 = this.cCP.cuo;
        editText2 = this.cCP.cAy;
        writeData2.setContent(editText2.getText().toString());
        writeData3 = this.cCP.cuo;
        int type = writeData3.getType();
        if (type == 0) {
            writeData6 = this.cCP.cuo;
            String forumId = writeData6.getForumId();
            writeData7 = this.cCP.cuo;
            com.baidu.tieba.tbadkCore.ao.a(forumId, writeData7);
        } else if (type == 1) {
            writeData4 = this.cCP.cuo;
            String threadId = writeData4.getThreadId();
            writeData5 = this.cCP.cuo;
            com.baidu.tieba.tbadkCore.ao.b(threadId, writeData5);
        }
        this.cCP.showToast(com.baidu.tieba.t.draft_save_success);
        handler = this.cCP.mHandler;
        handler.postDelayed(new az(this), 1000L);
    }
}
