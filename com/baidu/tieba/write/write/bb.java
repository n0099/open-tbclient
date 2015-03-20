package com.baidu.tieba.write.write;

import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import com.baidu.tieba.tbadkCore.PbEditor.EditorToolComponetContainer;
import com.baidu.tieba.write.editor.TbEditorToolButtonContainer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements View.OnTouchListener {
    final /* synthetic */ WriteActivity cyc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(WriteActivity writeActivity) {
        this.cyc = writeActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TbEditorToolButtonContainer tbEditorToolButtonContainer;
        EditorToolComponetContainer editorToolComponetContainer;
        EditText editText;
        if (motionEvent.getAction() == 1) {
            view.requestFocus();
            tbEditorToolButtonContainer = this.cyc.cxK;
            tbEditorToolButtonContainer.ale();
            editorToolComponetContainer = this.cyc.cmz;
            editText = this.cyc.cvS;
            editorToolComponetContainer.aa(editText);
            return false;
        }
        return false;
    }
}
