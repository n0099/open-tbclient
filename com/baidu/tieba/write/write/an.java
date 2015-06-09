package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.EditText;
import com.baidu.tieba.tbadkCore.PbEditor.EditorToolComponetContainer;
import com.baidu.tieba.write.editor.TbEditorToolButtonContainer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements View.OnClickListener {
    final /* synthetic */ WriteActivity cCQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(WriteActivity writeActivity) {
        this.cCQ = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        TbEditorToolButtonContainer tbEditorToolButtonContainer;
        EditorToolComponetContainer editorToolComponetContainer;
        EditorToolComponetContainer editorToolComponetContainer2;
        EditText editText2;
        editText = this.cCQ.cAz;
        editText.requestFocus();
        tbEditorToolButtonContainer = this.cCQ.cCy;
        tbEditorToolButtonContainer.anf();
        editorToolComponetContainer = this.cCQ.cqP;
        editorToolComponetContainer.any();
        editorToolComponetContainer2 = this.cCQ.cqP;
        editText2 = this.cCQ.cAz;
        editorToolComponetContainer2.Z(editText2);
    }
}
