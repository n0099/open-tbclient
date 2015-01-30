package com.baidu.tieba.tbadkCore.PbEditor;

import android.view.View;
/* loaded from: classes.dex */
class aj implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.editortool.w aCI;
    final /* synthetic */ PbEditorToolView bWA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(PbEditorToolView pbEditorToolView, com.baidu.tbadk.editortool.w wVar) {
        this.bWA = pbEditorToolView;
        this.aCI = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aCI.handleAction(10, null);
    }
}
