package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.EditText;
/* loaded from: classes.dex */
class bh implements View.OnClickListener {
    final /* synthetic */ WriteActivity fDQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(WriteActivity writeActivity) {
        this.fDQ = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.editortools.j jVar;
        int bng;
        EditText editText;
        EditText editText2;
        jVar = this.fDQ.aun;
        jVar.b(new com.baidu.tbadk.editortools.a(5, -1, null));
        bng = this.fDQ.bng();
        if (bng >= 0) {
            editText = this.fDQ.eWJ;
            if (bng < editText.getText().length()) {
                editText2 = this.fDQ.eWJ;
                editText2.setSelection(bng);
            }
        }
    }
}
