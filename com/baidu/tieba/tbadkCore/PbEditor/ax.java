package com.baidu.tieba.tbadkCore.PbEditor;

import android.view.View;
/* loaded from: classes.dex */
class ax implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.editortool.w aBH;
    final /* synthetic */ TbEditorToolButtonContainer bVj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(TbEditorToolButtonContainer tbEditorToolButtonContainer, com.baidu.tbadk.editortool.w wVar) {
        this.bVj = tbEditorToolButtonContainer;
        this.aBH = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view instanceof EditorToolButton) {
            this.bVj.a((EditorToolButton) view, this.aBH);
        }
    }
}
