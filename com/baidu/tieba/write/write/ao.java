package com.baidu.tieba.write.write;

import android.os.Handler;
import android.widget.EditText;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements a.b {
    final /* synthetic */ WriteActivity fMl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(WriteActivity writeActivity) {
        this.fMl = writeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        WriteData writeData;
        EditText boV;
        WriteData writeData2;
        EditText boU;
        WriteData writeData3;
        WriteData writeData4;
        WriteData writeData5;
        Handler handler;
        WriteData writeData6;
        WriteData writeData7;
        aVar.dismiss();
        writeData = this.fMl.mData;
        boV = this.fMl.boV();
        writeData.setTitle(boV.getText().toString());
        writeData2 = this.fMl.mData;
        boU = this.fMl.boU();
        writeData2.setContent(boU.getText().toString());
        writeData3 = this.fMl.mData;
        int type = writeData3.getType();
        if (type == 0) {
            writeData6 = this.fMl.mData;
            String forumId = writeData6.getForumId();
            writeData7 = this.fMl.mData;
            com.baidu.tieba.tbadkCore.aa.b(forumId, writeData7);
        } else if (type == 1) {
            writeData4 = this.fMl.mData;
            String threadId = writeData4.getThreadId();
            writeData5 = this.fMl.mData;
            com.baidu.tieba.tbadkCore.aa.c(threadId, writeData5);
        }
        this.fMl.showToast(r.l.draft_save_success);
        handler = this.fMl.mHandler;
        handler.postDelayed(new ap(this), 1000L);
    }
}
