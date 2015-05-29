package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.EditText;
import com.baidu.tieba.tbadkCore.PbEditor.EditorToolComponetContainer;
import com.baidu.tieba.write.editor.TbEditorToolButtonContainer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements View.OnClickListener {
    final /* synthetic */ WriteActivity cCP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(WriteActivity writeActivity) {
        this.cCP = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        TbEditorToolButtonContainer tbEditorToolButtonContainer;
        EditorToolComponetContainer editorToolComponetContainer;
        EditorToolComponetContainer editorToolComponetContainer2;
        EditText editText2;
        editText = this.cCP.cAy;
        editText.requestFocus();
        tbEditorToolButtonContainer = this.cCP.cCx;
        tbEditorToolButtonContainer.ane();
        editorToolComponetContainer = this.cCP.cqO;
        editorToolComponetContainer.anx();
        editorToolComponetContainer2 = this.cCP.cqO;
        editText2 = this.cCP.cAy;
        editorToolComponetContainer2.Z(editText2);
    }
}
