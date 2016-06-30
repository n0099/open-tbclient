package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.EditText;
/* loaded from: classes.dex */
class bg implements View.OnClickListener {
    final /* synthetic */ WriteActivity fJw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(WriteActivity writeActivity) {
        this.fJw = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.editortools.l lVar;
        int blX;
        EditText editText;
        EditText editText2;
        lVar = this.fJw.aqo;
        lVar.b(new com.baidu.tbadk.editortools.a(5, -1, null));
        blX = this.fJw.blX();
        if (blX >= 0) {
            editText = this.fJw.fFl;
            if (blX < editText.getText().length()) {
                editText2 = this.fJw.fFl;
                editText2.setSelection(blX);
            }
        }
    }
}
