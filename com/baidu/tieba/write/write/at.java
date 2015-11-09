package com.baidu.tieba.write.write;

import android.os.Handler;
import android.widget.EditText;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements a.b {
    final /* synthetic */ WriteActivity dsa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(WriteActivity writeActivity) {
        this.dsa = writeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        WriteData writeData;
        EditText aEn;
        WriteData writeData2;
        EditText aEm;
        WriteData writeData3;
        WriteData writeData4;
        WriteData writeData5;
        Handler handler;
        WriteData writeData6;
        WriteData writeData7;
        aVar.dismiss();
        writeData = this.dsa.ddI;
        aEn = this.dsa.aEn();
        writeData.setTitle(aEn.getText().toString());
        writeData2 = this.dsa.ddI;
        aEm = this.dsa.aEm();
        writeData2.setContent(aEm.getText().toString());
        writeData3 = this.dsa.ddI;
        int type = writeData3.getType();
        if (type == 0) {
            writeData6 = this.dsa.ddI;
            String forumId = writeData6.getForumId();
            writeData7 = this.dsa.ddI;
            com.baidu.tieba.tbadkCore.ad.b(forumId, writeData7);
        } else if (type == 1) {
            writeData4 = this.dsa.ddI;
            String threadId = writeData4.getThreadId();
            writeData5 = this.dsa.ddI;
            com.baidu.tieba.tbadkCore.ad.c(threadId, writeData5);
        }
        this.dsa.showToast(i.h.draft_save_success);
        handler = this.dsa.mHandler;
        handler.postDelayed(new au(this), 1000L);
    }
}
