package com.baidu.tieba.write.write;

import android.widget.EditText;
import com.baidu.tieba.tbadkCore.PbEditor.EditorToolComponetContainer;
/* loaded from: classes.dex */
class bp implements Runnable {
    final /* synthetic */ WriteActivity cCQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(WriteActivity writeActivity) {
        this.cCQ = writeActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        EditText editText;
        EditorToolComponetContainer editorToolComponetContainer;
        EditText editText2;
        EditorToolComponetContainer editorToolComponetContainer2;
        EditText editText3;
        editText = this.cCQ.cAv;
        if (editText.getVisibility() == 0) {
            editorToolComponetContainer2 = this.cCQ.cqP;
            editText3 = this.cCQ.cAv;
            editorToolComponetContainer2.ab(editText3);
            return;
        }
        editorToolComponetContainer = this.cCQ.cqP;
        editText2 = this.cCQ.cAz;
        editorToolComponetContainer.ab(editText2);
    }
}
