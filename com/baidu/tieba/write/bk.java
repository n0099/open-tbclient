package com.baidu.tieba.write;

import android.view.View;
import android.widget.EditText;
import com.baidu.tieba.tbadkCore.PbEditor.EditorToolComponetContainer;
/* loaded from: classes.dex */
class bk implements View.OnClickListener {
    final /* synthetic */ WriteActivity cgR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(WriteActivity writeActivity) {
        this.cgR = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditorToolComponetContainer editorToolComponetContainer;
        int akp;
        EditText editText;
        EditText editText2;
        EditorToolComponetContainer editorToolComponetContainer2;
        editorToolComponetContainer = this.cgR.bWj;
        if (editorToolComponetContainer.afI()) {
            editorToolComponetContainer2 = this.cgR.bWj;
            editorToolComponetContainer2.hideAll();
        }
        akp = this.cgR.akp();
        if (akp >= 0) {
            editText = this.cgR.bPJ;
            if (akp < editText.getText().length()) {
                editText2 = this.cgR.bPJ;
                editText2.setSelection(akp);
            }
        }
    }
}
