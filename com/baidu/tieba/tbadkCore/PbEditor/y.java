package com.baidu.tieba.tbadkCore.PbEditor;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class y implements View.OnTouchListener {
    private final /* synthetic */ com.baidu.tbadk.editortool.v aKR;
    final /* synthetic */ PbEditorToolView cre;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(PbEditorToolView pbEditorToolView, com.baidu.tbadk.editortool.v vVar) {
        this.cre = pbEditorToolView;
        this.aKR = vVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.cre.mEditText.requestFocus();
            this.aKR.handleAction(12, null);
        }
        return false;
    }
}
