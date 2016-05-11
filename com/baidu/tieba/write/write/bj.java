package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.EditText;
/* loaded from: classes.dex */
class bj implements View.OnClickListener {
    final /* synthetic */ WriteActivity feb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(WriteActivity writeActivity) {
        this.feb = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.editortools.l lVar;
        int bdv;
        EditText editText;
        EditText editText2;
        lVar = this.feb.apy;
        lVar.b(new com.baidu.tbadk.editortools.a(5, -1, null));
        bdv = this.feb.bdv();
        if (bdv >= 0) {
            editText = this.feb.fai;
            if (bdv < editText.getText().length()) {
                editText2 = this.feb.fai;
                editText2.setSelection(bdv);
            }
        }
    }
}
