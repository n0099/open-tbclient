package com.baidu.tieba.write;

import com.baidu.tieba.tbadkCore.PbEditor.TbEditorToolButtonContainer;
/* loaded from: classes.dex */
class ad implements com.baidu.tieba.tbadkCore.bubble.y {
    final /* synthetic */ WriteActivity cgS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(WriteActivity writeActivity) {
        this.cgS = writeActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.bubble.y
    public void jx() {
        TbEditorToolButtonContainer tbEditorToolButtonContainer;
        this.cgS.bVb = null;
        this.cgS.eQ(false);
        tbEditorToolButtonContainer = this.cgS.cgA;
        tbEditorToolButtonContainer.vA();
    }
}
