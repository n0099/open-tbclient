package com.baidu.tieba.write.write;

import android.os.Handler;
import android.widget.EditText;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements a.b {
    final /* synthetic */ WriteActivity ets;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(WriteActivity writeActivity) {
        this.ets = writeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        WriteData writeData;
        EditText aUZ;
        WriteData writeData2;
        EditText aUY;
        WriteData writeData3;
        WriteData writeData4;
        WriteData writeData5;
        Handler handler;
        WriteData writeData6;
        WriteData writeData7;
        aVar.dismiss();
        writeData = this.ets.dZC;
        aUZ = this.ets.aUZ();
        writeData.setTitle(aUZ.getText().toString());
        writeData2 = this.ets.dZC;
        aUY = this.ets.aUY();
        writeData2.setContent(aUY.getText().toString());
        writeData3 = this.ets.dZC;
        int type = writeData3.getType();
        if (type == 0) {
            writeData6 = this.ets.dZC;
            String forumId = writeData6.getForumId();
            writeData7 = this.ets.dZC;
            com.baidu.tieba.tbadkCore.ad.b(forumId, writeData7);
        } else if (type == 1) {
            writeData4 = this.ets.dZC;
            String threadId = writeData4.getThreadId();
            writeData5 = this.ets.dZC;
            com.baidu.tieba.tbadkCore.ad.c(threadId, writeData5);
        }
        this.ets.showToast(t.j.draft_save_success);
        handler = this.ets.mHandler;
        handler.postDelayed(new ar(this), 1000L);
    }
}
