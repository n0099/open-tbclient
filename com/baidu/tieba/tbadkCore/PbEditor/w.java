package com.baidu.tieba.tbadkCore.PbEditor;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.editortool.v aIJ;
    final /* synthetic */ PbEditorToolButtonContainer cnd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(PbEditorToolButtonContainer pbEditorToolButtonContainer, com.baidu.tbadk.editortool.v vVar) {
        this.cnd = pbEditorToolButtonContainer;
        this.aIJ = vVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view instanceof EditorToolButton) {
            this.cnd.a((EditorToolButton) view, this.aIJ);
        }
    }
}
