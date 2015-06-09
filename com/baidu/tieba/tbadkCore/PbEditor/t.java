package com.baidu.tieba.tbadkCore.PbEditor;
/* loaded from: classes.dex */
class t implements ae {
    final /* synthetic */ s cqY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar) {
        this.cqY = sVar;
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.ae
    public void aoa() {
        PbEditor pbEditor;
        PbEditor pbEditor2;
        pbEditor = this.cqY.cqW;
        pbEditor.cqU = true;
        pbEditor2 = this.cqY.cqW;
        pbEditor2.cqO.getEditText().requestFocus();
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.ae
    public void aob() {
    }
}
