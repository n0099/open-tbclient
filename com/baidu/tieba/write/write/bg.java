package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.EditText;
/* loaded from: classes.dex */
class bg implements View.OnClickListener {
    final /* synthetic */ WriteActivity dpI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(WriteActivity writeActivity) {
        this.dpI = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.editortools.j jVar;
        int aCW;
        EditText editText;
        EditText editText2;
        jVar = this.dpI.dpc;
        jVar.b(new com.baidu.tbadk.editortools.a(5, -1, null));
        aCW = this.dpI.aCW();
        if (aCW >= 0) {
            editText = this.dpI.dmd;
            if (aCW < editText.getText().length()) {
                editText2 = this.dpI.dmd;
                editText2.setSelection(aCW);
            }
        }
    }
}
