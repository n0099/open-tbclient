package com.baidu.tieba.write;

import com.baidu.tieba.editortool.TbEditorToolButtonContainer;
/* loaded from: classes.dex */
class bm implements com.baidu.tieba.bubble.t {
    final /* synthetic */ WriteActivity bUm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(WriteActivity writeActivity) {
        this.bUm = writeActivity;
    }

    @Override // com.baidu.tieba.bubble.t
    public void hz() {
        TbEditorToolButtonContainer tbEditorToolButtonContainer;
        TbEditorToolButtonContainer tbEditorToolButtonContainer2;
        this.bUm.aqi = null;
        this.bUm.eM(false);
        tbEditorToolButtonContainer = this.bUm.bTU;
        if (tbEditorToolButtonContainer != null) {
            tbEditorToolButtonContainer2 = this.bUm.bTU;
            tbEditorToolButtonContainer2.rI();
        }
    }
}
