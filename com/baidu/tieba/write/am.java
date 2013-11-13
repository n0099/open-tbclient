package com.baidu.tieba.write;

import android.content.DialogInterface;
import android.widget.EditText;
import com.baidu.tieba.data.WriteData;
import com.baidu.tieba.util.DatabaseService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteActivity f2686a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(WriteActivity writeActivity) {
        this.f2686a = writeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        WriteData writeData;
        EditText editText;
        WriteData writeData2;
        EditText editText2;
        WriteData writeData3;
        writeData = this.f2686a.b;
        editText = this.f2686a.f;
        writeData.setTitle(editText.getText().toString());
        writeData2 = this.f2686a.b;
        editText2 = this.f2686a.h;
        writeData2.setContent(editText2.getText().toString());
        writeData3 = this.f2686a.b;
        DatabaseService.b(writeData3);
        this.f2686a.finish();
    }
}
