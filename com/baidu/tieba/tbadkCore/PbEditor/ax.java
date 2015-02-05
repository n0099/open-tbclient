package com.baidu.tieba.tbadkCore.PbEditor;

import android.view.View;
/* loaded from: classes.dex */
class ax implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.editortool.w aCF;
    final /* synthetic */ TbEditorToolButtonContainer bXa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(TbEditorToolButtonContainer tbEditorToolButtonContainer, com.baidu.tbadk.editortool.w wVar) {
        this.bXa = tbEditorToolButtonContainer;
        this.aCF = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view instanceof EditorToolButton) {
            this.bXa.a((EditorToolButton) view, this.aCF);
        }
    }
}
