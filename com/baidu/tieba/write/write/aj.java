package com.baidu.tieba.write.write;

import com.baidu.tieba.write.editor.TbEditorToolButtonContainer;
/* loaded from: classes.dex */
class aj implements com.baidu.tieba.tbadkCore.c.h {
    final /* synthetic */ WriteActivity cCP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(WriteActivity writeActivity) {
        this.cCP = writeActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.c.h
    public void nf() {
        TbEditorToolButtonContainer tbEditorToolButtonContainer;
        this.cCP.bCP = null;
        this.cCP.fF(false);
        tbEditorToolButtonContainer = this.cCP.cCx;
        tbEditorToolButtonContainer.zL();
    }
}
