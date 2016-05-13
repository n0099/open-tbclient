package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.EditText;
/* loaded from: classes.dex */
class bj implements View.OnClickListener {
    final /* synthetic */ WriteActivity fea;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(WriteActivity writeActivity) {
        this.fea = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.editortools.l lVar;
        int bdC;
        EditText editText;
        EditText editText2;
        lVar = this.fea.apy;
        lVar.b(new com.baidu.tbadk.editortools.a(5, -1, null));
        bdC = this.fea.bdC();
        if (bdC >= 0) {
            editText = this.fea.fah;
            if (bdC < editText.getText().length()) {
                editText2 = this.fea.fah;
                editText2.setSelection(bdC);
            }
        }
    }
}
