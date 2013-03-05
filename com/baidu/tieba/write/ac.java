package com.baidu.tieba.write;

import android.content.DialogInterface;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements DialogInterface.OnClickListener {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.b.y yVar;
        EditText editText;
        com.baidu.tieba.b.y yVar2;
        EditText editText2;
        com.baidu.tieba.b.y yVar3;
        yVar = this.a.c;
        editText = this.a.g;
        yVar.a(editText.getText().toString());
        yVar2 = this.a.c;
        editText2 = this.a.h;
        yVar2.b(editText2.getText().toString());
        yVar3 = this.a.c;
        com.baidu.tieba.c.k.b(yVar3);
        this.a.finish();
    }
}
