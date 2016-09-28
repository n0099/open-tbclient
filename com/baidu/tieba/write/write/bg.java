package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.EditText;
/* loaded from: classes.dex */
class bg implements View.OnClickListener {
    final /* synthetic */ WriteActivity ghD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(WriteActivity writeActivity) {
        this.ghD = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.editortools.l lVar;
        int btN;
        EditText editText;
        EditText editText2;
        lVar = this.ghD.atO;
        lVar.b(new com.baidu.tbadk.editortools.a(5, -1, null));
        btN = this.ghD.btN();
        if (btN >= 0) {
            editText = this.ghD.flH;
            if (btN < editText.getText().length()) {
                editText2 = this.ghD.flH;
                editText2.setSelection(btN);
            }
        }
    }
}
