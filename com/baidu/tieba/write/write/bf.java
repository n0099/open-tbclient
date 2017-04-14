package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.EditText;
/* loaded from: classes.dex */
class bf implements View.OnClickListener {
    final /* synthetic */ WriteActivity fSq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(WriteActivity writeActivity) {
        this.fSq = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.editortools.j jVar;
        int bpa;
        EditText editText;
        EditText editText2;
        jVar = this.fSq.azd;
        jVar.b(new com.baidu.tbadk.editortools.a(5, -1, null));
        bpa = this.fSq.bpa();
        if (bpa >= 0) {
            editText = this.fSq.fmi;
            if (bpa < editText.getText().length()) {
                editText2 = this.fSq.fmi;
                editText2.setSelection(bpa);
            }
        }
    }
}
