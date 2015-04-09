package com.baidu.tieba.tbadkCore.PbEditor;

import android.view.View;
/* loaded from: classes.dex */
class aa implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.editortool.v aIJ;
    final /* synthetic */ PbEditorToolView cng;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(PbEditorToolView pbEditorToolView, com.baidu.tbadk.editortool.v vVar) {
        this.cng = pbEditorToolView;
        this.aIJ = vVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aIJ.handleAction(10, null);
    }
}
