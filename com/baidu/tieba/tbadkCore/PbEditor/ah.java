package com.baidu.tieba.tbadkCore.PbEditor;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class ah implements View.OnTouchListener {
    private final /* synthetic */ com.baidu.tbadk.editortool.w aCI;
    final /* synthetic */ PbEditorToolView bWA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(PbEditorToolView pbEditorToolView, com.baidu.tbadk.editortool.w wVar) {
        this.bWA = pbEditorToolView;
        this.aCI = wVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.bWA.mEditText.requestFocus();
            this.aCI.handleAction(12, null);
        }
        return false;
    }
}
