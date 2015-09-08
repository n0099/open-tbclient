package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.EditText;
/* loaded from: classes.dex */
class bg implements View.OnClickListener {
    final /* synthetic */ WriteActivity ddQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(WriteActivity writeActivity) {
        this.ddQ = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.editortools.j jVar;
        int azu;
        EditText editText;
        EditText editText2;
        jVar = this.ddQ.ddl;
        jVar.b(new com.baidu.tbadk.editortools.a(5, -1, null));
        azu = this.ddQ.azu();
        if (azu >= 0) {
            editText = this.ddQ.dbb;
            if (azu < editText.getText().length()) {
                editText2 = this.ddQ.dbb;
                editText2.setSelection(azu);
            }
        }
    }
}
