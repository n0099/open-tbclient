package com.baidu.tieba.write.editor;

import android.view.View;
import com.baidu.tbadk.editortool.v;
import com.baidu.tieba.tbadkCore.PbEditor.EditorToolButton;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    private final /* synthetic */ v aKR;
    final /* synthetic */ TbEditorToolButtonContainer czF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(TbEditorToolButtonContainer tbEditorToolButtonContainer, v vVar) {
        this.czF = tbEditorToolButtonContainer;
        this.aKR = vVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view instanceof EditorToolButton) {
            this.czF.a((EditorToolButton) view, this.aKR);
        }
    }
}
