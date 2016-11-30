package com.baidu.tieba.write.write;

import android.os.Handler;
import android.widget.EditText;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements a.b {
    final /* synthetic */ WriteActivity gpp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(WriteActivity writeActivity) {
        this.gpp = writeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        WriteData writeData;
        EditText bwy;
        WriteData writeData2;
        EditText bwx;
        WriteData writeData3;
        WriteData writeData4;
        WriteData writeData5;
        Handler handler;
        WriteData writeData6;
        WriteData writeData7;
        aVar.dismiss();
        writeData = this.gpp.fst;
        bwy = this.gpp.bwy();
        writeData.setTitle(bwy.getText().toString());
        writeData2 = this.gpp.fst;
        bwx = this.gpp.bwx();
        writeData2.setContent(bwx.getText().toString());
        writeData3 = this.gpp.fst;
        int type = writeData3.getType();
        if (type == 0) {
            writeData6 = this.gpp.fst;
            String forumId = writeData6.getForumId();
            writeData7 = this.gpp.fst;
            com.baidu.tieba.tbadkCore.ad.b(forumId, writeData7);
        } else if (type == 1) {
            writeData4 = this.gpp.fst;
            String threadId = writeData4.getThreadId();
            writeData5 = this.gpp.fst;
            com.baidu.tieba.tbadkCore.ad.c(threadId, writeData5);
        }
        this.gpp.showToast(r.j.draft_save_success);
        handler = this.gpp.mHandler;
        handler.postDelayed(new aq(this), 1000L);
    }
}
