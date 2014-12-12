package com.baidu.tieba.write;

import android.view.View;
import android.widget.EditText;
import com.baidu.tieba.tbadkCore.PbEditor.EditorToolComponetContainer;
/* loaded from: classes.dex */
class bk implements View.OnClickListener {
    final /* synthetic */ WriteActivity cft;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(WriteActivity writeActivity) {
        this.cft = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditorToolComponetContainer editorToolComponetContainer;
        int ajX;
        EditText editText;
        EditText editText2;
        EditorToolComponetContainer editorToolComponetContainer2;
        editorToolComponetContainer = this.cft.bUs;
        if (editorToolComponetContainer.afj()) {
            editorToolComponetContainer2 = this.cft.bUs;
            editorToolComponetContainer2.hideAll();
        }
        ajX = this.cft.ajX();
        if (ajX >= 0) {
            editText = this.cft.bOa;
            if (ajX < editText.getText().length()) {
                editText2 = this.cft.bOa;
                editText2.setSelection(ajX);
            }
        }
    }
}
