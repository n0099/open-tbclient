package com.baidu.tieba.tbadkCore.PbEditor;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class ah implements View.OnTouchListener {
    private final /* synthetic */ com.baidu.tbadk.editortool.w aBH;
    final /* synthetic */ PbEditorToolView bUI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(PbEditorToolView pbEditorToolView, com.baidu.tbadk.editortool.w wVar) {
        this.bUI = pbEditorToolView;
        this.aBH = wVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.bUI.mEditText.requestFocus();
            this.aBH.handleAction(12, null);
        }
        return false;
    }
}
