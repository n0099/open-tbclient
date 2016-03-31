package com.baidu.tieba.write.write;

import android.os.Handler;
import android.widget.EditText;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements a.b {
    final /* synthetic */ WriteActivity eNd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(WriteActivity writeActivity) {
        this.eNd = writeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        WriteData writeData;
        EditText bbz;
        WriteData writeData2;
        EditText bby;
        WriteData writeData3;
        WriteData writeData4;
        WriteData writeData5;
        Handler handler;
        WriteData writeData6;
        WriteData writeData7;
        aVar.dismiss();
        writeData = this.eNd.esv;
        bbz = this.eNd.bbz();
        writeData.setTitle(bbz.getText().toString());
        writeData2 = this.eNd.esv;
        bby = this.eNd.bby();
        writeData2.setContent(bby.getText().toString());
        writeData3 = this.eNd.esv;
        int type = writeData3.getType();
        if (type == 0) {
            writeData6 = this.eNd.esv;
            String forumId = writeData6.getForumId();
            writeData7 = this.eNd.esv;
            com.baidu.tieba.tbadkCore.ad.b(forumId, writeData7);
        } else if (type == 1) {
            writeData4 = this.eNd.esv;
            String threadId = writeData4.getThreadId();
            writeData5 = this.eNd.esv;
            com.baidu.tieba.tbadkCore.ad.c(threadId, writeData5);
        }
        this.eNd.showToast(t.j.draft_save_success);
        handler = this.eNd.mHandler;
        handler.postDelayed(new as(this), 1000L);
    }
}
