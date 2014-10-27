package com.baidu.tieba.write;

import android.view.View;
import android.widget.EditText;
import com.baidu.tieba.editortool.EditorToolComponetContainer;
import com.baidu.tieba.editortool.TbEditorToolButtonContainer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements View.OnClickListener {
    final /* synthetic */ WriteActivity bTX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(WriteActivity writeActivity) {
        this.bTX = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        TbEditorToolButtonContainer tbEditorToolButtonContainer;
        EditorToolComponetContainer editorToolComponetContainer;
        EditorToolComponetContainer editorToolComponetContainer2;
        EditText editText2;
        editText = this.bTX.bJv;
        editText.requestFocus();
        tbEditorToolButtonContainer = this.bTX.bTF;
        tbEditorToolButtonContainer.Bg();
        editorToolComponetContainer = this.bTX.are;
        editorToolComponetContainer.BD();
        editorToolComponetContainer2 = this.bTX.are;
        editText2 = this.bTX.bJv;
        editorToolComponetContainer2.v(editText2);
    }
}
