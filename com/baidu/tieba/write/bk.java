package com.baidu.tieba.write;

import android.view.View;
import android.widget.EditText;
import com.baidu.tieba.editortool.EditorToolComponetContainer;
/* loaded from: classes.dex */
class bk implements View.OnClickListener {
    final /* synthetic */ WriteActivity bUm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(WriteActivity writeActivity) {
        this.bUm = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditorToolComponetContainer editorToolComponetContainer;
        int aft;
        EditText editText;
        EditText editText2;
        EditorToolComponetContainer editorToolComponetContainer2;
        editorToolComponetContainer = this.bUm.arn;
        if (editorToolComponetContainer.BD()) {
            editorToolComponetContainer2 = this.bUm.arn;
            editorToolComponetContainer2.BE();
        }
        aft = this.bUm.aft();
        if (aft >= 0) {
            editText = this.bUm.bJK;
            if (aft < editText.getText().length()) {
                editText2 = this.bUm.bJK;
                editText2.setSelection(aft);
            }
        }
    }
}
