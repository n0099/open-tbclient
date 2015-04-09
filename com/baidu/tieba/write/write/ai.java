package com.baidu.tieba.write.write;

import com.baidu.tieba.write.editor.TbEditorToolButtonContainer;
/* loaded from: classes.dex */
class ai implements com.baidu.tieba.tbadkCore.b.h {
    final /* synthetic */ WriteActivity cyx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(WriteActivity writeActivity) {
        this.cyx = writeActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.b.h
    public void mM() {
        TbEditorToolButtonContainer tbEditorToolButtonContainer;
        this.cyx.bAb = null;
        this.cyx.fj(false);
        tbEditorToolButtonContainer = this.cyx.cyf;
        tbEditorToolButtonContainer.yY();
    }
}
