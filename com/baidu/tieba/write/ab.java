package com.baidu.tieba.write;

import android.content.DialogInterface;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements DialogInterface.OnClickListener {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.b.u uVar;
        EditText editText;
        com.baidu.tieba.b.u uVar2;
        EditText editText2;
        com.baidu.tieba.b.u uVar3;
        uVar = this.a.b;
        editText = this.a.f;
        uVar.a(editText.getText().toString());
        uVar2 = this.a.b;
        editText2 = this.a.g;
        uVar2.b(editText2.getText().toString());
        uVar3 = this.a.b;
        com.baidu.tieba.c.k.b(uVar3);
        this.a.finish();
    }
}
