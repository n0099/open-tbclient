package com.baidu.tieba.tbadkCore.PbEditor;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnTouchListener {
    private final /* synthetic */ com.baidu.tbadk.editortool.v aIB;
    final /* synthetic */ PbEditorToolView cmQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(PbEditorToolView pbEditorToolView, com.baidu.tbadk.editortool.v vVar) {
        this.cmQ = pbEditorToolView;
        this.aIB = vVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.cmQ.mEditText.requestFocus();
            this.aIB.handleAction(12, null);
        }
        return false;
    }
}
