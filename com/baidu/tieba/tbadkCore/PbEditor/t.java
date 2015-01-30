package com.baidu.tieba.tbadkCore.PbEditor;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ EditorToolComponetContainer bWa;
    private final /* synthetic */ int bWc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(EditorToolComponetContainer editorToolComponetContainer, int i) {
        this.bWa = editorToolComponetContainer;
        this.bWc = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.editortool.w wVar;
        wVar = this.bWa.Yj;
        wVar.handleAction(this.bWc, null);
    }
}
