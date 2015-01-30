package com.baidu.tieba.tbadkCore.PbEditor;

import android.view.View;
/* loaded from: classes.dex */
class ax implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.editortool.w aCI;
    final /* synthetic */ TbEditorToolButtonContainer bXb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(TbEditorToolButtonContainer tbEditorToolButtonContainer, com.baidu.tbadk.editortool.w wVar) {
        this.bXb = tbEditorToolButtonContainer;
        this.aCI = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view instanceof EditorToolButton) {
            this.bXb.a((EditorToolButton) view, this.aCI);
        }
    }
}
