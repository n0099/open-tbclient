package com.baidu.tieba.tbadkCore.PbEditor;

import android.view.View;
/* loaded from: classes.dex */
class aj implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.editortool.w aBH;
    final /* synthetic */ PbEditorToolView bUI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(PbEditorToolView pbEditorToolView, com.baidu.tbadk.editortool.w wVar) {
        this.bUI = pbEditorToolView;
        this.aBH = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aBH.handleAction(10, null);
    }
}
