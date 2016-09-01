package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.EditText;
/* loaded from: classes.dex */
class bg implements View.OnClickListener {
    final /* synthetic */ WriteActivity gfs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(WriteActivity writeActivity) {
        this.gfs = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.editortools.l lVar;
        int bth;
        EditText editText;
        EditText editText2;
        lVar = this.gfs.auk;
        lVar.b(new com.baidu.tbadk.editortools.a(5, -1, null));
        bth = this.gfs.bth();
        if (bth >= 0) {
            editText = this.gfs.fjb;
            if (bth < editText.getText().length()) {
                editText2 = this.gfs.fjb;
                editText2.setSelection(bth);
            }
        }
    }
}
