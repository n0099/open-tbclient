package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.EditText;
/* loaded from: classes.dex */
class bg implements View.OnClickListener {
    final /* synthetic */ WriteActivity eNd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(WriteActivity writeActivity) {
        this.eNd = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.editortools.l lVar;
        int bbi;
        EditText editText;
        EditText editText2;
        lVar = this.eNd.atG;
        lVar.b(new com.baidu.tbadk.editortools.a(5, -1, null));
        bbi = this.eNd.bbi();
        if (bbi >= 0) {
            editText = this.eNd.eJr;
            if (bbi < editText.getText().length()) {
                editText2 = this.eNd.eJr;
                editText2.setSelection(bbi);
            }
        }
    }
}
