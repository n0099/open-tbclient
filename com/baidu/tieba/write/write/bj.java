package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.EditText;
/* loaded from: classes.dex */
class bj implements View.OnClickListener {
    final /* synthetic */ WriteActivity fSV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(WriteActivity writeActivity) {
        this.fSV = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.editortools.j jVar;
        int bod;
        EditText editText;
        EditText editText2;
        jVar = this.fSV.azd;
        jVar.b(new com.baidu.tbadk.editortools.a(5, -1, null));
        bod = this.fSV.bod();
        if (bod >= 0) {
            editText = this.fSV.fkB;
            if (bod < editText.getText().length()) {
                editText2 = this.fSV.fkB;
                editText2.setSelection(bod);
            }
        }
    }
}
