package com.baidu.tieba.tbadkCore.PbEditor;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ EditorToolComponetContainer bUi;
    private final /* synthetic */ int bUk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(EditorToolComponetContainer editorToolComponetContainer, int i) {
        this.bUi = editorToolComponetContainer;
        this.bUk = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.editortool.w wVar;
        wVar = this.bUi.XD;
        wVar.handleAction(this.bUk, null);
    }
}
