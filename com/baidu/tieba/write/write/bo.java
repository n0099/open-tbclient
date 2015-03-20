package com.baidu.tieba.write.write;

import android.widget.EditText;
import com.baidu.tieba.tbadkCore.PbEditor.EditorToolComponetContainer;
/* loaded from: classes.dex */
class bo implements Runnable {
    final /* synthetic */ WriteActivity cyc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(WriteActivity writeActivity) {
        this.cyc = writeActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        EditText editText;
        EditorToolComponetContainer editorToolComponetContainer;
        EditText editText2;
        EditorToolComponetContainer editorToolComponetContainer2;
        EditText editText3;
        editText = this.cyc.cvO;
        if (editText.getVisibility() == 0) {
            editorToolComponetContainer2 = this.cyc.cmz;
            editText3 = this.cyc.cvO;
            editorToolComponetContainer2.aa(editText3);
            return;
        }
        editorToolComponetContainer = this.cyc.cmz;
        editText2 = this.cyc.cvS;
        editorToolComponetContainer.aa(editText2);
    }
}
