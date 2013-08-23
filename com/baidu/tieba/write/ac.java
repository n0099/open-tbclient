package com.baidu.tieba.write;

import android.content.DialogInterface;
import android.widget.EditText;
import com.baidu.tieba.data.WriteData;
import com.baidu.tieba.util.DatabaseService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteActivity f1902a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(WriteActivity writeActivity) {
        this.f1902a = writeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        WriteData writeData;
        EditText editText;
        WriteData writeData2;
        EditText editText2;
        WriteData writeData3;
        writeData = this.f1902a.f1897a;
        editText = this.f1902a.e;
        writeData.setTitle(editText.getText().toString());
        writeData2 = this.f1902a.f1897a;
        editText2 = this.f1902a.f;
        writeData2.setContent(editText2.getText().toString());
        writeData3 = this.f1902a.f1897a;
        DatabaseService.b(writeData3);
        this.f1902a.finish();
    }
}
