package com.baidu.tieba.write.write;

import android.os.Handler;
import android.widget.EditText;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ WriteActivity cyx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(WriteActivity writeActivity) {
        this.cyx = writeActivity;
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
        writeData = this.cyx.cqk;
        editText = this.cyx.cwe;
        writeData.setTitle(editText.getText().toString());
        writeData2 = this.cyx.cqk;
        editText2 = this.cyx.cwi;
        writeData2.setContent(editText2.getText().toString());
        writeData3 = this.cyx.cqk;
        int type = writeData3.getType();
        if (type == 0) {
            writeData6 = this.cyx.cqk;
            String forumId = writeData6.getForumId();
            writeData7 = this.cyx.cqk;
            com.baidu.tieba.tbadkCore.ao.a(forumId, writeData7);
        } else if (type == 1) {
            writeData4 = this.cyx.cqk;
            String threadId = writeData4.getThreadId();
            writeData5 = this.cyx.cqk;
            com.baidu.tieba.tbadkCore.ao.b(threadId, writeData5);
        }
        this.cyx.showToast(com.baidu.tieba.y.draft_save_success);
        handler = this.cyx.mHandler;
        handler.postDelayed(new ay(this), 1000L);
    }
}
