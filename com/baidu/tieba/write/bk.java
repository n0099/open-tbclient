package com.baidu.tieba.write;

import android.view.View;
import android.widget.EditText;
import com.baidu.tieba.tbadkCore.PbEditor.EditorToolComponetContainer;
/* loaded from: classes.dex */
class bk implements View.OnClickListener {
    final /* synthetic */ WriteActivity cgS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(WriteActivity writeActivity) {
        this.cgS = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditorToolComponetContainer editorToolComponetContainer;
        int aku;
        EditText editText;
        EditText editText2;
        EditorToolComponetContainer editorToolComponetContainer2;
        editorToolComponetContainer = this.cgS.bWk;
        if (editorToolComponetContainer.afN()) {
            editorToolComponetContainer2 = this.cgS.bWk;
            editorToolComponetContainer2.hideAll();
        }
        aku = this.cgS.aku();
        if (aku >= 0) {
            editText = this.cgS.bPK;
            if (aku < editText.getText().length()) {
                editText2 = this.cgS.bPK;
                editText2.setSelection(aku);
            }
        }
    }
}
