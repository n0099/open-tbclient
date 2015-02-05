package com.baidu.tieba.write;

import com.baidu.tieba.tbadkCore.PbEditor.TbEditorToolButtonContainer;
/* loaded from: classes.dex */
class ad implements com.baidu.tieba.tbadkCore.bubble.y {
    final /* synthetic */ WriteActivity cgR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(WriteActivity writeActivity) {
        this.cgR = writeActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.bubble.y
    public void jq() {
        TbEditorToolButtonContainer tbEditorToolButtonContainer;
        this.cgR.bVa = null;
        this.cgR.eQ(false);
        tbEditorToolButtonContainer = this.cgR.cgz;
        tbEditorToolButtonContainer.vu();
    }
}
