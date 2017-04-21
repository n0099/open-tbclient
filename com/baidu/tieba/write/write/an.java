package com.baidu.tieba.write.write;

import android.os.Handler;
import android.widget.EditText;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements a.b {
    final /* synthetic */ WriteActivity fUM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(WriteActivity writeActivity) {
        this.fUM = writeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        WriteData writeData;
        EditText bqt;
        WriteData writeData2;
        EditText bqs;
        WriteData writeData3;
        WriteData writeData4;
        WriteData writeData5;
        Handler handler;
        WriteData writeData6;
        WriteData writeData7;
        aVar.dismiss();
        writeData = this.fUM.mData;
        bqt = this.fUM.bqt();
        writeData.setTitle(bqt.getText().toString());
        writeData2 = this.fUM.mData;
        bqs = this.fUM.bqs();
        writeData2.setContent(bqs.getText().toString());
        writeData3 = this.fUM.mData;
        int type = writeData3.getType();
        if (type == 0) {
            writeData6 = this.fUM.mData;
            String forumId = writeData6.getForumId();
            writeData7 = this.fUM.mData;
            com.baidu.tieba.tbadkCore.z.b(forumId, writeData7);
        } else if (type == 1) {
            writeData4 = this.fUM.mData;
            String threadId = writeData4.getThreadId();
            writeData5 = this.fUM.mData;
            com.baidu.tieba.tbadkCore.z.c(threadId, writeData5);
        }
        this.fUM.showToast(w.l.draft_save_success);
        handler = this.fUM.mHandler;
        handler.postDelayed(new ao(this), 1000L);
    }
}
