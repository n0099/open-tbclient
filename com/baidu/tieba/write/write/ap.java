package com.baidu.tieba.write.write;

import android.os.Handler;
import android.widget.EditText;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements a.b {
    final /* synthetic */ WriteActivity cUM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(WriteActivity writeActivity) {
        this.cUM = writeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
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
        writeData = this.cUM.cKS;
        editText = this.cUM.cSk;
        writeData.setTitle(editText.getText().toString());
        writeData2 = this.cUM.cKS;
        editText2 = this.cUM.cSo;
        writeData2.setContent(editText2.getText().toString());
        writeData3 = this.cUM.cKS;
        int type = writeData3.getType();
        if (type == 0) {
            writeData6 = this.cUM.cKS;
            String forumId = writeData6.getForumId();
            writeData7 = this.cUM.cKS;
            com.baidu.tieba.tbadkCore.ac.b(forumId, writeData7);
        } else if (type == 1) {
            writeData4 = this.cUM.cKS;
            String threadId = writeData4.getThreadId();
            writeData5 = this.cUM.cKS;
            com.baidu.tieba.tbadkCore.ac.c(threadId, writeData5);
        }
        this.cUM.showToast(i.C0057i.draft_save_success);
        handler = this.cUM.mHandler;
        handler.postDelayed(new aq(this), 1000L);
    }
}
