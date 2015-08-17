package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.EditText;
/* loaded from: classes.dex */
class bc implements View.OnClickListener {
    final /* synthetic */ WriteActivity cUM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(WriteActivity writeActivity) {
        this.cUM = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.editortools.j jVar;
        int auW;
        EditText editText;
        EditText editText2;
        jVar = this.cUM.cUo;
        jVar.b(new com.baidu.tbadk.editortools.a(5, -1, null));
        auW = this.cUM.auW();
        if (auW >= 0) {
            editText = this.cUM.cSo;
            if (auW < editText.getText().length()) {
                editText2 = this.cUM.cSo;
                editText2.setSelection(auW);
            }
        }
    }
}
