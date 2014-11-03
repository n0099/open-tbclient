package com.baidu.tieba.write;

import android.widget.EditText;
import com.baidu.tieba.editortool.EditorToolComponetContainer;
/* loaded from: classes.dex */
class bj implements Runnable {
    final /* synthetic */ WriteActivity bUm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(WriteActivity writeActivity) {
        this.bUm = writeActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        EditText editText;
        EditorToolComponetContainer editorToolComponetContainer;
        EditText editText2;
        EditorToolComponetContainer editorToolComponetContainer2;
        EditText editText3;
        editText = this.bUm.bJG;
        if (editText.getVisibility() == 0) {
            editorToolComponetContainer2 = this.bUm.arn;
            editText3 = this.bUm.bJG;
            editorToolComponetContainer2.x(editText3);
            return;
        }
        editorToolComponetContainer = this.bUm.arn;
        editText2 = this.bUm.bJK;
        editorToolComponetContainer.x(editText2);
    }
}
