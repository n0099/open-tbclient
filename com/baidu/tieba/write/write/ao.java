package com.baidu.tieba.write.write;

import android.os.Handler;
import android.widget.EditText;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements a.b {
    final /* synthetic */ WriteActivity fQG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(WriteActivity writeActivity) {
        this.fQG = writeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        WriteData writeData;
        EditText boJ;
        WriteData writeData2;
        EditText boI;
        WriteData writeData3;
        WriteData writeData4;
        WriteData writeData5;
        Handler handler;
        WriteData writeData6;
        WriteData writeData7;
        aVar.dismiss();
        writeData = this.fQG.mData;
        boJ = this.fQG.boJ();
        writeData.setTitle(boJ.getText().toString());
        writeData2 = this.fQG.mData;
        boI = this.fQG.boI();
        writeData2.setContent(boI.getText().toString());
        writeData3 = this.fQG.mData;
        int type = writeData3.getType();
        if (type == 0) {
            writeData6 = this.fQG.mData;
            String forumId = writeData6.getForumId();
            writeData7 = this.fQG.mData;
            com.baidu.tieba.tbadkCore.z.b(forumId, writeData7);
        } else if (type == 1) {
            writeData4 = this.fQG.mData;
            String threadId = writeData4.getThreadId();
            writeData5 = this.fQG.mData;
            com.baidu.tieba.tbadkCore.z.c(threadId, writeData5);
        }
        this.fQG.showToast(w.l.draft_save_success);
        handler = this.fQG.mHandler;
        handler.postDelayed(new ap(this), 1000L);
    }
}
