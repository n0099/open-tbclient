package com.baidu.tieba.tbadkCore.PbEditor;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.editortool.w aCI;
    final /* synthetic */ PbEditorToolButtonContainer bWx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(PbEditorToolButtonContainer pbEditorToolButtonContainer, com.baidu.tbadk.editortool.w wVar) {
        this.bWx = pbEditorToolButtonContainer;
        this.aCI = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view instanceof EditorToolButton) {
            this.bWx.a((EditorToolButton) view, this.aCI);
        }
    }
}
