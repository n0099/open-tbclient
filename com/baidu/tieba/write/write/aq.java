package com.baidu.tieba.write.write;

import android.os.Handler;
import android.widget.EditText;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements a.b {
    final /* synthetic */ WriteActivity fJw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(WriteActivity writeActivity) {
        this.fJw = writeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        WriteData writeData;
        EditText bmq;
        WriteData writeData2;
        EditText bmp;
        WriteData writeData3;
        WriteData writeData4;
        WriteData writeData5;
        Handler handler;
        WriteData writeData6;
        WriteData writeData7;
        aVar.dismiss();
        writeData = this.fJw.fau;
        bmq = this.fJw.bmq();
        writeData.setTitle(bmq.getText().toString());
        writeData2 = this.fJw.fau;
        bmp = this.fJw.bmp();
        writeData2.setContent(bmp.getText().toString());
        writeData3 = this.fJw.fau;
        int type = writeData3.getType();
        if (type == 0) {
            writeData6 = this.fJw.fau;
            String forumId = writeData6.getForumId();
            writeData7 = this.fJw.fau;
            com.baidu.tieba.tbadkCore.af.b(forumId, writeData7);
        } else if (type == 1) {
            writeData4 = this.fJw.fau;
            String threadId = writeData4.getThreadId();
            writeData5 = this.fJw.fau;
            com.baidu.tieba.tbadkCore.af.c(threadId, writeData5);
        }
        this.fJw.showToast(u.j.draft_save_success);
        handler = this.fJw.mHandler;
        handler.postDelayed(new ar(this), 1000L);
    }
}
