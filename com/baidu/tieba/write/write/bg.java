package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.EditText;
/* loaded from: classes.dex */
class bg implements View.OnClickListener {
    final /* synthetic */ WriteActivity fVn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(WriteActivity writeActivity) {
        this.fVn = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.editortools.l lVar;
        int boS;
        EditText editText;
        EditText editText2;
        lVar = this.fVn.ard;
        lVar.b(new com.baidu.tbadk.editortools.a(5, -1, null));
        boS = this.fVn.boS();
        if (boS >= 0) {
            editText = this.fVn.faN;
            if (boS < editText.getText().length()) {
                editText2 = this.fVn.faN;
                editText2.setSelection(boS);
            }
        }
    }
}
