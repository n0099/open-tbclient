package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.EditText;
/* loaded from: classes.dex */
class bh implements View.OnClickListener {
    final /* synthetic */ WriteActivity gpp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(WriteActivity writeActivity) {
        this.gpp = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.editortools.l lVar;
        int bwi;
        EditText editText;
        EditText editText2;
        lVar = this.gpp.auI;
        lVar.b(new com.baidu.tbadk.editortools.a(5, -1, null));
        bwi = this.gpp.bwi();
        if (bwi >= 0) {
            editText = this.gpp.fsQ;
            if (bwi < editText.getText().length()) {
                editText2 = this.gpp.fsQ;
                editText2.setSelection(bwi);
            }
        }
    }
}
