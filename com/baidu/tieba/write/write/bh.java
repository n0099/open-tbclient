package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.EditText;
/* loaded from: classes.dex */
class bh implements View.OnClickListener {
    final /* synthetic */ WriteActivity glP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(WriteActivity writeActivity) {
        this.glP = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.editortools.j jVar;
        int bua;
        EditText editText;
        EditText editText2;
        jVar = this.glP.azR;
        jVar.b(new com.baidu.tbadk.editortools.a(5, -1, null));
        bua = this.glP.bua();
        if (bua >= 0) {
            editText = this.glP.fCD;
            if (bua < editText.getText().length()) {
                editText2 = this.glP.fCD;
                editText2.setSelection(bua);
            }
        }
    }
}
