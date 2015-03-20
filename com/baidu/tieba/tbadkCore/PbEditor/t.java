package com.baidu.tieba.tbadkCore.PbEditor;
/* loaded from: classes.dex */
class t implements ae {
    final /* synthetic */ s cmI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar) {
        this.cmI = sVar;
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.ae
    public void alY() {
        PbEditor pbEditor;
        PbEditor pbEditor2;
        pbEditor = this.cmI.cmG;
        pbEditor.cmE = true;
        pbEditor2 = this.cmI.cmG;
        pbEditor2.cmy.getEditText().requestFocus();
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.ae
    public void alZ() {
    }
}
