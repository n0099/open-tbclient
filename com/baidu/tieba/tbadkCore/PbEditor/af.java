package com.baidu.tieba.tbadkCore.PbEditor;

import android.view.View;
/* loaded from: classes.dex */
class af implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.editortool.w aBH;
    final /* synthetic */ PbEditorToolButtonContainer bUF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(PbEditorToolButtonContainer pbEditorToolButtonContainer, com.baidu.tbadk.editortool.w wVar) {
        this.bUF = pbEditorToolButtonContainer;
        this.aBH = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view instanceof EditorToolButton) {
            this.bUF.a((EditorToolButton) view, this.aBH);
        }
    }
}
