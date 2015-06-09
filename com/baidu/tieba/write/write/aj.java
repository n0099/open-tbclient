package com.baidu.tieba.write.write;

import com.baidu.tieba.write.editor.TbEditorToolButtonContainer;
/* loaded from: classes.dex */
class aj implements com.baidu.tieba.tbadkCore.c.h {
    final /* synthetic */ WriteActivity cCQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(WriteActivity writeActivity) {
        this.cCQ = writeActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.c.h
    public void nf() {
        TbEditorToolButtonContainer tbEditorToolButtonContainer;
        this.cCQ.bCQ = null;
        this.cCQ.fF(false);
        tbEditorToolButtonContainer = this.cCQ.cCy;
        tbEditorToolButtonContainer.zM();
    }
}
