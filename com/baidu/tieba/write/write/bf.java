package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.EditText;
/* loaded from: classes.dex */
class bf implements View.OnClickListener {
    final /* synthetic */ WriteActivity fUM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(WriteActivity writeActivity) {
        this.fUM = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.editortools.j jVar;
        int bqb;
        EditText editText;
        EditText editText2;
        jVar = this.fUM.azf;
        jVar.b(new com.baidu.tbadk.editortools.a(5, -1, null));
        bqb = this.fUM.bqb();
        if (bqb >= 0) {
            editText = this.fUM.foA;
            if (bqb < editText.getText().length()) {
                editText2 = this.fUM.foA;
                editText2.setSelection(bqb);
            }
        }
    }
}
