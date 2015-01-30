package com.baidu.tieba.write;

import android.widget.EditText;
import com.baidu.tieba.tbadkCore.PbEditor.EditorToolComponetContainer;
/* loaded from: classes.dex */
class bj implements Runnable {
    final /* synthetic */ WriteActivity cgS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(WriteActivity writeActivity) {
        this.cgS = writeActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        EditText editText;
        EditorToolComponetContainer editorToolComponetContainer;
        EditText editText2;
        EditorToolComponetContainer editorToolComponetContainer2;
        EditText editText3;
        editText = this.cgS.bPG;
        if (editText.getVisibility() == 0) {
            editorToolComponetContainer2 = this.cgS.bWk;
            editText3 = this.cgS.bPG;
            editorToolComponetContainer2.X(editText3);
            return;
        }
        editorToolComponetContainer = this.cgS.bWk;
        editText2 = this.cgS.bPK;
        editorToolComponetContainer.X(editText2);
    }
}
