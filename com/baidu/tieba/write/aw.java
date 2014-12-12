package com.baidu.tieba.write;

import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import com.baidu.tieba.tbadkCore.PbEditor.EditorToolComponetContainer;
import com.baidu.tieba.tbadkCore.PbEditor.TbEditorToolButtonContainer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements View.OnTouchListener {
    final /* synthetic */ WriteActivity cft;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(WriteActivity writeActivity) {
        this.cft = writeActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TbEditorToolButtonContainer tbEditorToolButtonContainer;
        EditorToolComponetContainer editorToolComponetContainer;
        EditText editText;
        if (motionEvent.getAction() == 1) {
            view.requestFocus();
            tbEditorToolButtonContainer = this.cft.cfb;
            tbEditorToolButtonContainer.aeS();
            editorToolComponetContainer = this.cft.bUs;
            editText = this.cft.bOa;
            editorToolComponetContainer.V(editText);
            return false;
        }
        return false;
    }
}
