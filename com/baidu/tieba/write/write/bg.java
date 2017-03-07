package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.EditText;
/* loaded from: classes.dex */
class bg implements View.OnClickListener {
    final /* synthetic */ WriteActivity fQG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(WriteActivity writeActivity) {
        this.fQG = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.editortools.j jVar;
        int bor;
        EditText editText;
        EditText editText2;
        jVar = this.fQG.ayN;
        jVar.b(new com.baidu.tbadk.editortools.a(5, -1, null));
        bor = this.fQG.bor();
        if (bor >= 0) {
            editText = this.fQG.fkA;
            if (bor < editText.getText().length()) {
                editText2 = this.fQG.fkA;
                editText2.setSelection(bor);
            }
        }
    }
}
