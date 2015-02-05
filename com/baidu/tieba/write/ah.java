package com.baidu.tieba.write;

import android.view.View;
import android.widget.EditText;
import com.baidu.tieba.tbadkCore.PbEditor.EditorToolComponetContainer;
import com.baidu.tieba.tbadkCore.PbEditor.TbEditorToolButtonContainer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements View.OnClickListener {
    final /* synthetic */ WriteActivity cgR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(WriteActivity writeActivity) {
        this.cgR = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        TbEditorToolButtonContainer tbEditorToolButtonContainer;
        EditorToolComponetContainer editorToolComponetContainer;
        EditorToolComponetContainer editorToolComponetContainer2;
        EditText editText2;
        editText = this.cgR.bPJ;
        editText.requestFocus();
        tbEditorToolButtonContainer = this.cgR.cgz;
        tbEditorToolButtonContainer.afr();
        editorToolComponetContainer = this.cgR.bWj;
        editorToolComponetContainer.afJ();
        editorToolComponetContainer2 = this.cgR.bWj;
        editText2 = this.cgR.bPJ;
        editorToolComponetContainer2.V(editText2);
    }
}
