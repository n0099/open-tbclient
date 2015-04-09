package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.EditText;
import com.baidu.tieba.tbadkCore.PbEditor.EditorToolComponetContainer;
import com.baidu.tieba.write.editor.TbEditorToolButtonContainer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements View.OnClickListener {
    final /* synthetic */ WriteActivity cyx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(WriteActivity writeActivity) {
        this.cyx = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        TbEditorToolButtonContainer tbEditorToolButtonContainer;
        EditorToolComponetContainer editorToolComponetContainer;
        EditorToolComponetContainer editorToolComponetContainer2;
        EditText editText2;
        editText = this.cyx.cwi;
        editText.requestFocus();
        tbEditorToolButtonContainer = this.cyx.cyf;
        tbEditorToolButtonContainer.alt();
        editorToolComponetContainer = this.cyx.cmP;
        editorToolComponetContainer.alL();
        editorToolComponetContainer2 = this.cyx.cmP;
        editText2 = this.cyx.cwi;
        editorToolComponetContainer2.Y(editText2);
    }
}
