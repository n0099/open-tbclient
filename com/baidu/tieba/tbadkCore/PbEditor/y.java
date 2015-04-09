package com.baidu.tieba.tbadkCore.PbEditor;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class y implements View.OnTouchListener {
    private final /* synthetic */ com.baidu.tbadk.editortool.v aIJ;
    final /* synthetic */ PbEditorToolView cng;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(PbEditorToolView pbEditorToolView, com.baidu.tbadk.editortool.v vVar) {
        this.cng = pbEditorToolView;
        this.aIJ = vVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.cng.mEditText.requestFocus();
            this.aIJ.handleAction(12, null);
        }
        return false;
    }
}
