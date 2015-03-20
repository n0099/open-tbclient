package com.baidu.tieba.tbadkCore.PbEditor;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.editortool.v aIB;
    final /* synthetic */ PbEditorToolButtonContainer cmN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(PbEditorToolButtonContainer pbEditorToolButtonContainer, com.baidu.tbadk.editortool.v vVar) {
        this.cmN = pbEditorToolButtonContainer;
        this.aIB = vVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view instanceof EditorToolButton) {
            this.cmN.a((EditorToolButton) view, this.aIB);
        }
    }
}
