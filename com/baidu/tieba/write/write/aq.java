package com.baidu.tieba.write.write;

import android.os.Handler;
import android.widget.EditText;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements a.b {
    final /* synthetic */ WriteActivity glP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(WriteActivity writeActivity) {
        this.glP = writeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        WriteData writeData;
        EditText but;
        WriteData writeData2;
        EditText bus;
        WriteData writeData3;
        WriteData writeData4;
        WriteData writeData5;
        Handler handler;
        WriteData writeData6;
        WriteData writeData7;
        aVar.dismiss();
        writeData = this.glP.mData;
        but = this.glP.but();
        writeData.setTitle(but.getText().toString());
        writeData2 = this.glP.mData;
        bus = this.glP.bus();
        writeData2.setContent(bus.getText().toString());
        writeData3 = this.glP.mData;
        int type = writeData3.getType();
        if (type == 0) {
            writeData6 = this.glP.mData;
            String forumId = writeData6.getForumId();
            writeData7 = this.glP.mData;
            com.baidu.tieba.tbadkCore.x.b(forumId, writeData7);
        } else if (type == 1) {
            writeData4 = this.glP.mData;
            String threadId = writeData4.getThreadId();
            writeData5 = this.glP.mData;
            com.baidu.tieba.tbadkCore.x.c(threadId, writeData5);
        }
        this.glP.showToast(w.l.draft_save_success);
        handler = this.glP.mHandler;
        handler.postDelayed(new ar(this), 1000L);
    }
}
