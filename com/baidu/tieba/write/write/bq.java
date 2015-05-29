package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.EditText;
import com.baidu.tieba.tbadkCore.PbEditor.EditorToolComponetContainer;
/* loaded from: classes.dex */
class bq implements View.OnClickListener {
    final /* synthetic */ WriteActivity cCP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(WriteActivity writeActivity) {
        this.cCP = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditorToolComponetContainer editorToolComponetContainer;
        int ate;
        EditText editText;
        EditText editText2;
        EditorToolComponetContainer editorToolComponetContainer2;
        editorToolComponetContainer = this.cCP.cqO;
        if (editorToolComponetContainer.anw()) {
            editorToolComponetContainer2 = this.cCP.cqO;
            editorToolComponetContainer2.hideAll();
        }
        ate = this.cCP.ate();
        if (ate >= 0) {
            editText = this.cCP.cAy;
            if (ate < editText.getText().length()) {
                editText2 = this.cCP.cAy;
                editText2.setSelection(ate);
            }
        }
    }
}
