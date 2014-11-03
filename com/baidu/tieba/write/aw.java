package com.baidu.tieba.write;

import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import com.baidu.tieba.editortool.EditorToolComponetContainer;
import com.baidu.tieba.editortool.TbEditorToolButtonContainer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements View.OnTouchListener {
    final /* synthetic */ WriteActivity bUm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(WriteActivity writeActivity) {
        this.bUm = writeActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TbEditorToolButtonContainer tbEditorToolButtonContainer;
        EditorToolComponetContainer editorToolComponetContainer;
        EditText editText;
        if (motionEvent.getAction() == 1) {
            view.requestFocus();
            tbEditorToolButtonContainer = this.bUm.bTU;
            tbEditorToolButtonContainer.Bi();
            editorToolComponetContainer = this.bUm.arn;
            editText = this.bUm.bJK;
            editorToolComponetContainer.x(editText);
            return false;
        }
        return false;
    }
}
