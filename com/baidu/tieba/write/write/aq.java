package com.baidu.tieba.write.write;

import android.os.Handler;
import android.widget.EditText;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements a.b {
    final /* synthetic */ WriteActivity gfs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(WriteActivity writeActivity) {
        this.gfs = writeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        WriteData writeData;
        EditText btz;
        WriteData writeData2;
        EditText bty;
        WriteData writeData3;
        WriteData writeData4;
        WriteData writeData5;
        Handler handler;
        WriteData writeData6;
        WriteData writeData7;
        aVar.dismiss();
        writeData = this.gfs.fiE;
        btz = this.gfs.btz();
        writeData.setTitle(btz.getText().toString());
        writeData2 = this.gfs.fiE;
        bty = this.gfs.bty();
        writeData2.setContent(bty.getText().toString());
        writeData3 = this.gfs.fiE;
        int type = writeData3.getType();
        if (type == 0) {
            writeData6 = this.gfs.fiE;
            String forumId = writeData6.getForumId();
            writeData7 = this.gfs.fiE;
            com.baidu.tieba.tbadkCore.ae.b(forumId, writeData7);
        } else if (type == 1) {
            writeData4 = this.gfs.fiE;
            String threadId = writeData4.getThreadId();
            writeData5 = this.gfs.fiE;
            com.baidu.tieba.tbadkCore.ae.c(threadId, writeData5);
        }
        this.gfs.showToast(t.j.draft_save_success);
        handler = this.gfs.mHandler;
        handler.postDelayed(new ar(this), 1000L);
    }
}
