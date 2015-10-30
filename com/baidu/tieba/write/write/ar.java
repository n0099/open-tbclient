package com.baidu.tieba.write.write;

import android.os.Handler;
import android.widget.EditText;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements a.b {
    final /* synthetic */ WriteActivity dqi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(WriteActivity writeActivity) {
        this.dqi = writeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        WriteData writeData;
        EditText aDt;
        WriteData writeData2;
        EditText aDs;
        WriteData writeData3;
        WriteData writeData4;
        WriteData writeData5;
        Handler handler;
        WriteData writeData6;
        WriteData writeData7;
        aVar.dismiss();
        writeData = this.dqi.dbx;
        aDt = this.dqi.aDt();
        writeData.setTitle(aDt.getText().toString());
        writeData2 = this.dqi.dbx;
        aDs = this.dqi.aDs();
        writeData2.setContent(aDs.getText().toString());
        writeData3 = this.dqi.dbx;
        int type = writeData3.getType();
        if (type == 0) {
            writeData6 = this.dqi.dbx;
            String forumId = writeData6.getForumId();
            writeData7 = this.dqi.dbx;
            com.baidu.tieba.tbadkCore.ad.b(forumId, writeData7);
        } else if (type == 1) {
            writeData4 = this.dqi.dbx;
            String threadId = writeData4.getThreadId();
            writeData5 = this.dqi.dbx;
            com.baidu.tieba.tbadkCore.ad.c(threadId, writeData5);
        }
        this.dqi.showToast(i.h.draft_save_success);
        handler = this.dqi.mHandler;
        handler.postDelayed(new as(this), 1000L);
    }
}
