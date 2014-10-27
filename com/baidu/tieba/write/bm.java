package com.baidu.tieba.write;

import com.baidu.tieba.editortool.TbEditorToolButtonContainer;
/* loaded from: classes.dex */
class bm implements com.baidu.tieba.bubble.t {
    final /* synthetic */ WriteActivity bTX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(WriteActivity writeActivity) {
        this.bTX = writeActivity;
    }

    @Override // com.baidu.tieba.bubble.t
    public void hz() {
        TbEditorToolButtonContainer tbEditorToolButtonContainer;
        TbEditorToolButtonContainer tbEditorToolButtonContainer2;
        this.bTX.apZ = null;
        this.bTX.eM(false);
        tbEditorToolButtonContainer = this.bTX.bTF;
        if (tbEditorToolButtonContainer != null) {
            tbEditorToolButtonContainer2 = this.bTX.bTF;
            tbEditorToolButtonContainer2.rG();
        }
    }
}
