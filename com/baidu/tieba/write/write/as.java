package com.baidu.tieba.write.write;

import android.os.Handler;
import android.widget.EditText;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements a.b {
    final /* synthetic */ WriteActivity fSV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(WriteActivity writeActivity) {
        this.fSV = writeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        WriteData writeData;
        EditText box;
        WriteData writeData2;
        EditText bow;
        WriteData writeData3;
        WriteData writeData4;
        WriteData writeData5;
        Handler handler;
        WriteData writeData6;
        WriteData writeData7;
        aVar.dismiss();
        writeData = this.fSV.mData;
        box = this.fSV.box();
        writeData.setTitle(box.getText().toString());
        writeData2 = this.fSV.mData;
        bow = this.fSV.bow();
        writeData2.setContent(bow.getText().toString());
        writeData3 = this.fSV.mData;
        int type = writeData3.getType();
        if (type == 0) {
            writeData6 = this.fSV.mData;
            String forumId = writeData6.getForumId();
            writeData7 = this.fSV.mData;
            com.baidu.tieba.tbadkCore.x.b(forumId, writeData7);
        } else if (type == 1) {
            writeData4 = this.fSV.mData;
            String threadId = writeData4.getThreadId();
            writeData5 = this.fSV.mData;
            com.baidu.tieba.tbadkCore.x.c(threadId, writeData5);
        }
        this.fSV.showToast(w.l.draft_save_success);
        handler = this.fSV.mHandler;
        handler.postDelayed(new at(this), 1000L);
    }
}
