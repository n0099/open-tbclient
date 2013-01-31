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
        com.baidu.tieba.b.w wVar;
        EditText editText;
        com.baidu.tieba.b.w wVar2;
        EditText editText2;
        com.baidu.tieba.b.w wVar3;
        wVar = this.a.c;
        editText = this.a.g;
        wVar.a(editText.getText().toString());
        wVar2 = this.a.c;
        editText2 = this.a.h;
        wVar2.b(editText2.getText().toString());
        wVar3 = this.a.c;
        com.baidu.tieba.c.k.b(wVar3);
        this.a.finish();
    }
}
