package com.baidu.tieba.write;

import android.content.DialogInterface;
import android.widget.EditText;
import com.baidu.tieba.model.WriteModel;
import com.baidu.tieba.util.DatabaseService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteActivity f1555a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(WriteActivity writeActivity) {
        this.f1555a = writeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        WriteModel writeModel;
        EditText editText;
        WriteModel writeModel2;
        EditText editText2;
        WriteModel writeModel3;
        writeModel = this.f1555a.f1550a;
        editText = this.f1555a.e;
        writeModel.setTitle(editText.getText().toString());
        writeModel2 = this.f1555a.f1550a;
        editText2 = this.f1555a.f;
        writeModel2.setContent(editText2.getText().toString());
        writeModel3 = this.f1555a.f1550a;
        DatabaseService.b(writeModel3);
        this.f1555a.finish();
    }
}
