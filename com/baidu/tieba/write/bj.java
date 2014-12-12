package com.baidu.tieba.write;

import android.widget.EditText;
import com.baidu.tieba.tbadkCore.PbEditor.EditorToolComponetContainer;
/* loaded from: classes.dex */
class bj implements Runnable {
    final /* synthetic */ WriteActivity cft;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(WriteActivity writeActivity) {
        this.cft = writeActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        EditText editText;
        EditorToolComponetContainer editorToolComponetContainer;
        EditText editText2;
        EditorToolComponetContainer editorToolComponetContainer2;
        EditText editText3;
        editText = this.cft.bNW;
        if (editText.getVisibility() == 0) {
            editorToolComponetContainer2 = this.cft.bUs;
            editText3 = this.cft.bNW;
            editorToolComponetContainer2.V(editText3);
            return;
        }
        editorToolComponetContainer = this.cft.bUs;
        editText2 = this.cft.bOa;
        editorToolComponetContainer.V(editText2);
    }
}
