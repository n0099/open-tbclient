package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.EditText;
import com.baidu.tieba.tbadkCore.PbEditor.EditorToolComponetContainer;
/* loaded from: classes.dex */
class bq implements View.OnClickListener {
    final /* synthetic */ WriteActivity cCQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(WriteActivity writeActivity) {
        this.cCQ = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditorToolComponetContainer editorToolComponetContainer;
        int atf;
        EditText editText;
        EditText editText2;
        EditorToolComponetContainer editorToolComponetContainer2;
        editorToolComponetContainer = this.cCQ.cqP;
        if (editorToolComponetContainer.anx()) {
            editorToolComponetContainer2 = this.cCQ.cqP;
            editorToolComponetContainer2.hideAll();
        }
        atf = this.cCQ.atf();
        if (atf >= 0) {
            editText = this.cCQ.cAz;
            if (atf < editText.getText().length()) {
                editText2 = this.cCQ.cAz;
                editText2.setSelection(atf);
            }
        }
    }
}
