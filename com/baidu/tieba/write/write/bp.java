package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.EditText;
import com.baidu.tieba.tbadkCore.PbEditor.EditorToolComponetContainer;
/* loaded from: classes.dex */
class bp implements View.OnClickListener {
    final /* synthetic */ WriteActivity cyx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(WriteActivity writeActivity) {
        this.cyx = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditorToolComponetContainer editorToolComponetContainer;
        int aro;
        EditText editText;
        EditText editText2;
        EditorToolComponetContainer editorToolComponetContainer2;
        editorToolComponetContainer = this.cyx.cmP;
        if (editorToolComponetContainer.alK()) {
            editorToolComponetContainer2 = this.cyx.cmP;
            editorToolComponetContainer2.hideAll();
        }
        aro = this.cyx.aro();
        if (aro >= 0) {
            editText = this.cyx.cwi;
            if (aro < editText.getText().length()) {
                editText2 = this.cyx.cwi;
                editText2.setSelection(aro);
            }
        }
    }
}
