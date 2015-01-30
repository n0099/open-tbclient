package com.baidu.tieba.write;

import android.view.View;
import android.widget.EditText;
import com.baidu.tieba.tbadkCore.PbEditor.EditorToolComponetContainer;
import com.baidu.tieba.tbadkCore.PbEditor.TbEditorToolButtonContainer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements View.OnClickListener {
    final /* synthetic */ WriteActivity cgS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(WriteActivity writeActivity) {
        this.cgS = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        TbEditorToolButtonContainer tbEditorToolButtonContainer;
        EditorToolComponetContainer editorToolComponetContainer;
        EditorToolComponetContainer editorToolComponetContainer2;
        EditText editText2;
        editText = this.cgS.bPK;
        editText.requestFocus();
        tbEditorToolButtonContainer = this.cgS.cgA;
        tbEditorToolButtonContainer.afw();
        editorToolComponetContainer = this.cgS.bWk;
        editorToolComponetContainer.afO();
        editorToolComponetContainer2 = this.cgS.bWk;
        editText2 = this.cgS.bPK;
        editorToolComponetContainer2.V(editText2);
    }
}
