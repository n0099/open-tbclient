package com.baidu.tieba.write;

import android.view.View;
import android.widget.EditText;
import com.baidu.tieba.editortool.EditorToolComponetContainer;
/* loaded from: classes.dex */
class bk implements View.OnClickListener {
    final /* synthetic */ WriteActivity bTX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(WriteActivity writeActivity) {
        this.bTX = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditorToolComponetContainer editorToolComponetContainer;
        int afq;
        EditText editText;
        EditText editText2;
        EditorToolComponetContainer editorToolComponetContainer2;
        editorToolComponetContainer = this.bTX.are;
        if (editorToolComponetContainer.BB()) {
            editorToolComponetContainer2 = this.bTX.are;
            editorToolComponetContainer2.BC();
        }
        afq = this.bTX.afq();
        if (afq >= 0) {
            editText = this.bTX.bJv;
            if (afq < editText.getText().length()) {
                editText2 = this.bTX.bJv;
                editText2.setSelection(afq);
            }
        }
    }
}
