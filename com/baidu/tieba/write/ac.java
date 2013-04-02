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
        com.baidu.tieba.b.z zVar;
        EditText editText;
        com.baidu.tieba.b.z zVar2;
        EditText editText2;
        com.baidu.tieba.b.z zVar3;
        zVar = this.a.c;
        editText = this.a.g;
        zVar.a(editText.getText().toString());
        zVar2 = this.a.c;
        editText2 = this.a.h;
        zVar2.b(editText2.getText().toString());
        zVar3 = this.a.c;
        com.baidu.tieba.c.k.b(zVar3);
        this.a.finish();
    }
}
