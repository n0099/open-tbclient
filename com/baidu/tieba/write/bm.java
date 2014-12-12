package com.baidu.tieba.write;

import com.baidu.tieba.tbadkCore.PbEditor.TbEditorToolButtonContainer;
/* loaded from: classes.dex */
class bm implements com.baidu.tieba.tbadkCore.bubble.y {
    final /* synthetic */ WriteActivity cft;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(WriteActivity writeActivity) {
        this.cft = writeActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.bubble.y
    public void jw() {
        TbEditorToolButtonContainer tbEditorToolButtonContainer;
        TbEditorToolButtonContainer tbEditorToolButtonContainer2;
        this.cft.bTi = null;
        this.cft.eL(false);
        tbEditorToolButtonContainer = this.cft.cfb;
        if (tbEditorToolButtonContainer != null) {
            tbEditorToolButtonContainer2 = this.cft.cfb;
            tbEditorToolButtonContainer2.vj();
        }
    }
}
