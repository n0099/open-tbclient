package com.baidu.tieba.write.write;

import com.baidu.tieba.write.editor.TbEditorToolButtonContainer;
/* loaded from: classes.dex */
class ai implements com.baidu.tieba.tbadkCore.b.h {
    final /* synthetic */ WriteActivity cyc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(WriteActivity writeActivity) {
        this.cyc = writeActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.b.h
    public void mM() {
        TbEditorToolButtonContainer tbEditorToolButtonContainer;
        this.cyc.bzO = null;
        this.cyc.fk(false);
        tbEditorToolButtonContainer = this.cyc.cxK;
        tbEditorToolButtonContainer.yS();
    }
}
