package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.EditText;
import com.baidu.tieba.tbadkCore.PbEditor.EditorToolComponetContainer;
/* loaded from: classes.dex */
class bp implements View.OnClickListener {
    final /* synthetic */ WriteActivity cyc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(WriteActivity writeActivity) {
        this.cyc = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditorToolComponetContainer editorToolComponetContainer;
        int aqZ;
        EditText editText;
        EditText editText2;
        EditorToolComponetContainer editorToolComponetContainer2;
        editorToolComponetContainer = this.cyc.cmz;
        if (editorToolComponetContainer.alv()) {
            editorToolComponetContainer2 = this.cyc.cmz;
            editorToolComponetContainer2.hideAll();
        }
        aqZ = this.cyc.aqZ();
        if (aqZ >= 0) {
            editText = this.cyc.cvS;
            if (aqZ < editText.getText().length()) {
                editText2 = this.cyc.cvS;
                editText2.setSelection(aqZ);
            }
        }
    }
}
