package com.baidu.tieba.write;

import android.widget.EditText;
import com.baidu.tieba.editortool.EditorToolComponetContainer;
/* loaded from: classes.dex */
class bj implements Runnable {
    final /* synthetic */ WriteActivity bTX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(WriteActivity writeActivity) {
        this.bTX = writeActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        EditText editText;
        EditorToolComponetContainer editorToolComponetContainer;
        EditText editText2;
        EditorToolComponetContainer editorToolComponetContainer2;
        EditText editText3;
        editText = this.bTX.bJr;
        if (editText.getVisibility() == 0) {
            editorToolComponetContainer2 = this.bTX.are;
            editText3 = this.bTX.bJr;
            editorToolComponetContainer2.x(editText3);
            return;
        }
        editorToolComponetContainer = this.bTX.are;
        editText2 = this.bTX.bJv;
        editorToolComponetContainer.x(editText2);
    }
}
