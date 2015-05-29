package com.baidu.tieba.write.write;

import android.widget.EditText;
import com.baidu.tieba.tbadkCore.PbEditor.EditorToolComponetContainer;
/* loaded from: classes.dex */
class bp implements Runnable {
    final /* synthetic */ WriteActivity cCP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(WriteActivity writeActivity) {
        this.cCP = writeActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        EditText editText;
        EditorToolComponetContainer editorToolComponetContainer;
        EditText editText2;
        EditorToolComponetContainer editorToolComponetContainer2;
        EditText editText3;
        editText = this.cCP.cAu;
        if (editText.getVisibility() == 0) {
            editorToolComponetContainer2 = this.cCP.cqO;
            editText3 = this.cCP.cAu;
            editorToolComponetContainer2.ab(editText3);
            return;
        }
        editorToolComponetContainer = this.cCP.cqO;
        editText2 = this.cCP.cAy;
        editorToolComponetContainer.ab(editText2);
    }
}
