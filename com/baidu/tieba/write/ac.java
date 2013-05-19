package com.baidu.tieba.write;

import android.content.DialogInterface;
import android.widget.EditText;
import com.baidu.tieba.c.bp;
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
        bp bpVar;
        EditText editText;
        bp bpVar2;
        EditText editText2;
        bp bpVar3;
        bpVar = this.a.c;
        editText = this.a.g;
        bpVar.a(editText.getText().toString());
        bpVar2 = this.a.c;
        editText2 = this.a.h;
        bpVar2.b(editText2.getText().toString());
        bpVar3 = this.a.c;
        com.baidu.tieba.d.k.b(bpVar3);
        this.a.finish();
    }
}
