package com.baidu.tieba.write.write;

import android.os.Handler;
import android.widget.EditText;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements a.b {
    final /* synthetic */ WriteActivity fea;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(WriteActivity writeActivity) {
        this.fea = writeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        WriteData writeData;
        EditText bdV;
        WriteData writeData2;
        EditText bdU;
        WriteData writeData3;
        WriteData writeData4;
        WriteData writeData5;
        Handler handler;
        WriteData writeData6;
        WriteData writeData7;
        aVar.dismiss();
        writeData = this.fea.evE;
        bdV = this.fea.bdV();
        writeData.setTitle(bdV.getText().toString());
        writeData2 = this.fea.evE;
        bdU = this.fea.bdU();
        writeData2.setContent(bdU.getText().toString());
        writeData3 = this.fea.evE;
        int type = writeData3.getType();
        if (type == 0) {
            writeData6 = this.fea.evE;
            String forumId = writeData6.getForumId();
            writeData7 = this.fea.evE;
            com.baidu.tieba.tbadkCore.ae.b(forumId, writeData7);
        } else if (type == 1) {
            writeData4 = this.fea.evE;
            String threadId = writeData4.getThreadId();
            writeData5 = this.fea.evE;
            com.baidu.tieba.tbadkCore.ae.c(threadId, writeData5);
        }
        this.fea.showToast(t.j.draft_save_success);
        handler = this.fea.mHandler;
        handler.postDelayed(new at(this), 1000L);
    }
}
