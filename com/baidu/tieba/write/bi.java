package com.baidu.tieba.write;

import android.content.DialogInterface;
import android.os.Handler;
import android.widget.EditText;
import com.baidu.tieba.data.WriteData;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi implements DialogInterface.OnClickListener {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        WriteData writeData;
        EditText editText;
        WriteData writeData2;
        EditText editText2;
        WriteData writeData3;
        WriteData writeData4;
        Handler handler;
        writeData = this.a.b;
        editText = this.a.g;
        writeData.setTitle(editText.getText().toString());
        writeData2 = this.a.b;
        editText2 = this.a.j;
        writeData2.setContent(editText2.getText().toString());
        writeData3 = this.a.b;
        String forumId = writeData3.getForumId();
        writeData4 = this.a.b;
        af.a(forumId, writeData4);
        this.a.showToast(R.string.draft_save_success);
        handler = this.a.u;
        handler.postDelayed(new bj(this), 1000L);
    }
}
