package com.baidu.tieba.write.write;

import android.os.Handler;
import android.widget.EditText;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements a.b {
    final /* synthetic */ WriteActivity feb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(WriteActivity writeActivity) {
        this.feb = writeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        WriteData writeData;
        EditText bdO;
        WriteData writeData2;
        EditText bdN;
        WriteData writeData3;
        WriteData writeData4;
        WriteData writeData5;
        Handler handler;
        WriteData writeData6;
        WriteData writeData7;
        aVar.dismiss();
        writeData = this.feb.evE;
        bdO = this.feb.bdO();
        writeData.setTitle(bdO.getText().toString());
        writeData2 = this.feb.evE;
        bdN = this.feb.bdN();
        writeData2.setContent(bdN.getText().toString());
        writeData3 = this.feb.evE;
        int type = writeData3.getType();
        if (type == 0) {
            writeData6 = this.feb.evE;
            String forumId = writeData6.getForumId();
            writeData7 = this.feb.evE;
            com.baidu.tieba.tbadkCore.ae.b(forumId, writeData7);
        } else if (type == 1) {
            writeData4 = this.feb.evE;
            String threadId = writeData4.getThreadId();
            writeData5 = this.feb.evE;
            com.baidu.tieba.tbadkCore.ae.c(threadId, writeData5);
        }
        this.feb.showToast(t.j.draft_save_success);
        handler = this.feb.mHandler;
        handler.postDelayed(new at(this), 1000L);
    }
}
