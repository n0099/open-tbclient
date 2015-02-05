package com.baidu.tieba.write;

import android.widget.EditText;
import com.baidu.tieba.tbadkCore.PbEditor.EditorToolComponetContainer;
/* loaded from: classes.dex */
class bj implements Runnable {
    final /* synthetic */ WriteActivity cgR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(WriteActivity writeActivity) {
        this.cgR = writeActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        EditText editText;
        EditorToolComponetContainer editorToolComponetContainer;
        EditText editText2;
        EditorToolComponetContainer editorToolComponetContainer2;
        EditText editText3;
        editText = this.cgR.bPF;
        if (editText.getVisibility() == 0) {
            editorToolComponetContainer2 = this.cgR.bWj;
            editText3 = this.cgR.bPF;
            editorToolComponetContainer2.X(editText3);
            return;
        }
        editorToolComponetContainer = this.cgR.bWj;
        editText2 = this.cgR.bPJ;
        editorToolComponetContainer.X(editText2);
    }
}
