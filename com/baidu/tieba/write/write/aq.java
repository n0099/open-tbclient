package com.baidu.tieba.write.write;

import android.os.Handler;
import android.widget.EditText;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements a.b {
    final /* synthetic */ WriteActivity fVn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(WriteActivity writeActivity) {
        this.fVn = writeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        WriteData writeData;
        EditText bpk;
        WriteData writeData2;
        EditText bpj;
        WriteData writeData3;
        WriteData writeData4;
        WriteData writeData5;
        Handler handler;
        WriteData writeData6;
        WriteData writeData7;
        aVar.dismiss();
        writeData = this.fVn.faq;
        bpk = this.fVn.bpk();
        writeData.setTitle(bpk.getText().toString());
        writeData2 = this.fVn.faq;
        bpj = this.fVn.bpj();
        writeData2.setContent(bpj.getText().toString());
        writeData3 = this.fVn.faq;
        int type = writeData3.getType();
        if (type == 0) {
            writeData6 = this.fVn.faq;
            String forumId = writeData6.getForumId();
            writeData7 = this.fVn.faq;
            com.baidu.tieba.tbadkCore.af.b(forumId, writeData7);
        } else if (type == 1) {
            writeData4 = this.fVn.faq;
            String threadId = writeData4.getThreadId();
            writeData5 = this.fVn.faq;
            com.baidu.tieba.tbadkCore.af.c(threadId, writeData5);
        }
        this.fVn.showToast(u.j.draft_save_success);
        handler = this.fVn.mHandler;
        handler.postDelayed(new ar(this), 1000L);
    }
}
