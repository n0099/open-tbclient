package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.EditText;
/* loaded from: classes.dex */
class bi implements View.OnClickListener {
    final /* synthetic */ WriteActivity dYD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(WriteActivity writeActivity) {
        this.dYD = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.editortools.k kVar;
        int aLM;
        EditText editText;
        EditText editText2;
        kVar = this.dYD.aso;
        kVar.b(new com.baidu.tbadk.editortools.a(5, -1, null));
        aLM = this.dYD.aLM();
        if (aLM >= 0) {
            editText = this.dYD.dUQ;
            if (aLM < editText.getText().length()) {
                editText2 = this.dYD.dUQ;
                editText2.setSelection(aLM);
            }
        }
    }
}
