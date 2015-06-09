package com.baidu.tieba.tbadkCore.PbEditor;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class y implements View.OnTouchListener {
    private final /* synthetic */ com.baidu.tbadk.editortool.v aKS;
    final /* synthetic */ PbEditorToolView crf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(PbEditorToolView pbEditorToolView, com.baidu.tbadk.editortool.v vVar) {
        this.crf = pbEditorToolView;
        this.aKS = vVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.crf.mEditText.requestFocus();
            this.aKS.handleAction(12, null);
        }
        return false;
    }
}
