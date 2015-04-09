package com.baidu.tieba.write.write;

import android.widget.EditText;
import com.baidu.tieba.tbadkCore.PbEditor.EditorToolComponetContainer;
/* loaded from: classes.dex */
class bo implements Runnable {
    final /* synthetic */ WriteActivity cyx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(WriteActivity writeActivity) {
        this.cyx = writeActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        EditText editText;
        EditorToolComponetContainer editorToolComponetContainer;
        EditText editText2;
        EditorToolComponetContainer editorToolComponetContainer2;
        EditText editText3;
        editText = this.cyx.cwe;
        if (editText.getVisibility() == 0) {
            editorToolComponetContainer2 = this.cyx.cmP;
            editText3 = this.cyx.cwe;
            editorToolComponetContainer2.aa(editText3);
            return;
        }
        editorToolComponetContainer = this.cyx.cmP;
        editText2 = this.cyx.cwi;
        editorToolComponetContainer.aa(editText2);
    }
}
