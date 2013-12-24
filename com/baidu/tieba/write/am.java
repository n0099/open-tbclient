package com.baidu.tieba.write;

import android.content.DialogInterface;
import android.os.Handler;
import android.widget.EditText;
import com.baidu.tieba.data.WriteData;
import com.baidu.tieba.util.DatabaseService;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements DialogInterface.OnClickListener {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        WriteData writeData;
        EditText editText;
        WriteData writeData2;
        EditText editText2;
        WriteData writeData3;
        Handler handler;
        writeData = this.a.b;
        editText = this.a.f;
        writeData.setTitle(editText.getText().toString());
        writeData2 = this.a.b;
        editText2 = this.a.h;
        writeData2.setContent(editText2.getText().toString());
        writeData3 = this.a.b;
        DatabaseService.b(writeData3);
        this.a.showToast(R.string.draft_save_success);
        handler = this.a.s;
        handler.postDelayed(new an(this), 1000L);
    }
}
