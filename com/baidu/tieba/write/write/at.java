package com.baidu.tieba.write.write;

import android.os.Handler;
import android.widget.EditText;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements a.b {
    final /* synthetic */ WriteActivity dYD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(WriteActivity writeActivity) {
        this.dYD = writeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        WriteData writeData;
        EditText aMf;
        WriteData writeData2;
        EditText aMe;
        WriteData writeData3;
        WriteData writeData4;
        WriteData writeData5;
        Handler handler;
        WriteData writeData6;
        WriteData writeData7;
        aVar.dismiss();
        writeData = this.dYD.dJy;
        aMf = this.dYD.aMf();
        writeData.setTitle(aMf.getText().toString());
        writeData2 = this.dYD.dJy;
        aMe = this.dYD.aMe();
        writeData2.setContent(aMe.getText().toString());
        writeData3 = this.dYD.dJy;
        int type = writeData3.getType();
        if (type == 0) {
            writeData6 = this.dYD.dJy;
            String forumId = writeData6.getForumId();
            writeData7 = this.dYD.dJy;
            com.baidu.tieba.tbadkCore.ae.b(forumId, writeData7);
        } else if (type == 1) {
            writeData4 = this.dYD.dJy;
            String threadId = writeData4.getThreadId();
            writeData5 = this.dYD.dJy;
            com.baidu.tieba.tbadkCore.ae.c(threadId, writeData5);
        }
        this.dYD.showToast(n.j.draft_save_success);
        handler = this.dYD.mHandler;
        handler.postDelayed(new au(this), 1000L);
    }
}
