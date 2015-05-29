package com.baidu.tieba.tbadkCore.PbEditor;
/* loaded from: classes.dex */
class t implements ae {
    final /* synthetic */ s cqX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar) {
        this.cqX = sVar;
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.ae
    public void anZ() {
        PbEditor pbEditor;
        PbEditor pbEditor2;
        pbEditor = this.cqX.cqV;
        pbEditor.cqT = true;
        pbEditor2 = this.cqX.cqV;
        pbEditor2.cqN.getEditText().requestFocus();
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.ae
    public void aoa() {
    }
}
