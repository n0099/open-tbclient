package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.EditText;
/* loaded from: classes.dex */
class bi implements View.OnClickListener {
    final /* synthetic */ WriteActivity dRf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(WriteActivity writeActivity) {
        this.dRf = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.editortools.k kVar;
        int aJr;
        EditText editText;
        EditText editText2;
        kVar = this.dRf.aqK;
        kVar.b(new com.baidu.tbadk.editortools.a(5, -1, null));
        aJr = this.dRf.aJr();
        if (aJr >= 0) {
            editText = this.dRf.dNr;
            if (aJr < editText.getText().length()) {
                editText2 = this.dRf.dNr;
                editText2.setSelection(aJr);
            }
        }
    }
}
