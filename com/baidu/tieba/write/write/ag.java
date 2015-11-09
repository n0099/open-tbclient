package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements View.OnClickListener {
    final /* synthetic */ WriteActivity dsa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(WriteActivity writeActivity) {
        this.dsa = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        com.baidu.tbadk.editortools.j jVar;
        editText = this.dsa.dol;
        editText.requestFocus();
        jVar = this.dsa.drr;
        jVar.zc();
    }
}
