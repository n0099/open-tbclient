package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.EditText;
/* loaded from: classes.dex */
class bi implements View.OnClickListener {
    final /* synthetic */ WriteActivity dsa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(WriteActivity writeActivity) {
        this.dsa = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.editortools.j jVar;
        int aDU;
        EditText editText;
        EditText editText2;
        jVar = this.dsa.drr;
        jVar.b(new com.baidu.tbadk.editortools.a(5, -1, null));
        aDU = this.dsa.aDU();
        if (aDU >= 0) {
            editText = this.dsa.dol;
            if (aDU < editText.getText().length()) {
                editText2 = this.dsa.dol;
                editText2.setSelection(aDU);
            }
        }
    }
}
