package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.EditText;
import com.baidu.tieba.tbadkCore.PbEditor.EditorToolComponetContainer;
import com.baidu.tieba.write.editor.TbEditorToolButtonContainer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements View.OnClickListener {
    final /* synthetic */ WriteActivity cyc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(WriteActivity writeActivity) {
        this.cyc = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        TbEditorToolButtonContainer tbEditorToolButtonContainer;
        EditorToolComponetContainer editorToolComponetContainer;
        EditorToolComponetContainer editorToolComponetContainer2;
        EditText editText2;
        editText = this.cyc.cvS;
        editText.requestFocus();
        tbEditorToolButtonContainer = this.cyc.cxK;
        tbEditorToolButtonContainer.ale();
        editorToolComponetContainer = this.cyc.cmz;
        editorToolComponetContainer.alw();
        editorToolComponetContainer2 = this.cyc.cmz;
        editText2 = this.cyc.cvS;
        editorToolComponetContainer2.Y(editText2);
    }
}
