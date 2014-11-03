package com.baidu.tieba.write;

import android.view.View;
import android.widget.EditText;
import com.baidu.tieba.editortool.EditorToolComponetContainer;
import com.baidu.tieba.editortool.TbEditorToolButtonContainer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements View.OnClickListener {
    final /* synthetic */ WriteActivity bUm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(WriteActivity writeActivity) {
        this.bUm = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        TbEditorToolButtonContainer tbEditorToolButtonContainer;
        EditorToolComponetContainer editorToolComponetContainer;
        EditorToolComponetContainer editorToolComponetContainer2;
        EditText editText2;
        editText = this.bUm.bJK;
        editText.requestFocus();
        tbEditorToolButtonContainer = this.bUm.bTU;
        tbEditorToolButtonContainer.Bi();
        editorToolComponetContainer = this.bUm.arn;
        editorToolComponetContainer.BF();
        editorToolComponetContainer2 = this.bUm.arn;
        editText2 = this.bUm.bJK;
        editorToolComponetContainer2.v(editText2);
    }
}
