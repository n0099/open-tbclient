package com.baidu.tieba.write;

import android.content.DialogInterface;
import android.widget.EditText;
import com.baidu.tieba.c.bs;
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
        bs bsVar;
        EditText editText;
        bs bsVar2;
        EditText editText2;
        bs bsVar3;
        bsVar = this.a.c;
        editText = this.a.g;
        bsVar.a(editText.getText().toString());
        bsVar2 = this.a.c;
        editText2 = this.a.h;
        bsVar2.b(editText2.getText().toString());
        bsVar3 = this.a.c;
        com.baidu.tieba.d.k.b(bsVar3);
        this.a.finish();
    }
}
