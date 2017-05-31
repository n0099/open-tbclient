package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.EditText;
/* loaded from: classes.dex */
class bj implements View.OnClickListener {
    final /* synthetic */ WriteActivity gaR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(WriteActivity writeActivity) {
        this.gaR = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.editortools.j jVar;
        int bpC;
        EditText editText;
        EditText editText2;
        jVar = this.gaR.ayP;
        jVar.b(new com.baidu.tbadk.editortools.a(5, -1, null));
        bpC = this.gaR.bpC();
        if (bpC >= 0) {
            editText = this.gaR.fst;
            if (bpC < editText.getText().length()) {
                editText2 = this.gaR.fst;
                editText2.setSelection(bpC);
            }
        }
    }
}
