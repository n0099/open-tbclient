package com.baidu.tieba.tbadkCore.PbEditor;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.editortool.v aKS;
    final /* synthetic */ PbEditorToolButtonContainer crc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(PbEditorToolButtonContainer pbEditorToolButtonContainer, com.baidu.tbadk.editortool.v vVar) {
        this.crc = pbEditorToolButtonContainer;
        this.aKS = vVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view instanceof EditorToolButton) {
            this.crc.a((EditorToolButton) view, this.aKS);
        }
    }
}
