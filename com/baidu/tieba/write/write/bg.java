package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.EditText;
/* loaded from: classes.dex */
class bg implements View.OnClickListener {
    final /* synthetic */ WriteActivity dqi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(WriteActivity writeActivity) {
        this.dqi = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.editortools.j jVar;
        int aDc;
        EditText editText;
        EditText editText2;
        jVar = this.dqi.dpD;
        jVar.b(new com.baidu.tbadk.editortools.a(5, -1, null));
        aDc = this.dqi.aDc();
        if (aDc >= 0) {
            editText = this.dqi.dmD;
            if (aDc < editText.getText().length()) {
                editText2 = this.dqi.dmD;
                editText2.setSelection(aDc);
            }
        }
    }
}
