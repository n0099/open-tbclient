package com.baidu.tieba.write;

import android.view.View;
import android.widget.EditText;
import com.baidu.tieba.tbadkCore.PbEditor.EditorToolComponetContainer;
import com.baidu.tieba.tbadkCore.PbEditor.TbEditorToolButtonContainer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements View.OnClickListener {
    final /* synthetic */ WriteActivity cft;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(WriteActivity writeActivity) {
        this.cft = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        TbEditorToolButtonContainer tbEditorToolButtonContainer;
        EditorToolComponetContainer editorToolComponetContainer;
        EditorToolComponetContainer editorToolComponetContainer2;
        EditText editText2;
        editText = this.cft.bOa;
        editText.requestFocus();
        tbEditorToolButtonContainer = this.cft.cfb;
        tbEditorToolButtonContainer.aeS();
        editorToolComponetContainer = this.cft.bUs;
        editorToolComponetContainer.afk();
        editorToolComponetContainer2 = this.cft.bUs;
        editText2 = this.cft.bOa;
        editorToolComponetContainer2.T(editText2);
    }
}
