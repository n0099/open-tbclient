package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.EditText;
/* loaded from: classes.dex */
class bg implements View.OnClickListener {
    final /* synthetic */ WriteActivity fMl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(WriteActivity writeActivity) {
        this.fMl = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.editortools.j jVar;
        int boE;
        EditText editText;
        EditText editText2;
        jVar = this.fMl.ats;
        jVar.b(new com.baidu.tbadk.editortools.a(5, -1, null));
        boE = this.fMl.boE();
        if (boE >= 0) {
            editText = this.fMl.fgd;
            if (boE < editText.getText().length()) {
                editText2 = this.fMl.fgd;
                editText2.setSelection(boE);
            }
        }
    }
}
