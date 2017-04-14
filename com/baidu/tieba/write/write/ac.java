package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements View.OnClickListener {
    final /* synthetic */ WriteActivity fSq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(WriteActivity writeActivity) {
        this.fSq = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        com.baidu.tbadk.editortools.j jVar;
        editText = this.fSq.fmi;
        editText.requestFocus();
        jVar = this.fSq.azd;
        jVar.BC();
    }
}
