package com.baidu.tieba.write.write;

import android.os.Handler;
import android.widget.EditText;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements a.b {
    final /* synthetic */ WriteActivity gaR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(WriteActivity writeActivity) {
        this.gaR = writeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        WriteData writeData;
        EditText bpW;
        WriteData writeData2;
        EditText bpV;
        WriteData writeData3;
        WriteData writeData4;
        WriteData writeData5;
        Handler handler;
        WriteData writeData6;
        WriteData writeData7;
        aVar.dismiss();
        writeData = this.gaR.mData;
        bpW = this.gaR.bpW();
        writeData.setTitle(bpW.getText().toString());
        writeData2 = this.gaR.mData;
        bpV = this.gaR.bpV();
        writeData2.setContent(bpV.getText().toString());
        writeData3 = this.gaR.mData;
        int type = writeData3.getType();
        if (type == 0) {
            writeData6 = this.gaR.mData;
            String forumId = writeData6.getForumId();
            writeData7 = this.gaR.mData;
            com.baidu.tieba.tbadkCore.x.b(forumId, writeData7);
        } else if (type == 1) {
            writeData4 = this.gaR.mData;
            String threadId = writeData4.getThreadId();
            writeData5 = this.gaR.mData;
            com.baidu.tieba.tbadkCore.x.c(threadId, writeData5);
        }
        this.gaR.showToast(w.l.draft_save_success);
        handler = this.gaR.mHandler;
        handler.postDelayed(new at(this), 1000L);
    }
}
