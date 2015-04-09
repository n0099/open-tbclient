package com.baidu.tieba.tbadkCore.PbEditor;
/* loaded from: classes.dex */
class t implements ae {
    final /* synthetic */ s cmY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar) {
        this.cmY = sVar;
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.ae
    public void amn() {
        PbEditor pbEditor;
        PbEditor pbEditor2;
        pbEditor = this.cmY.cmW;
        pbEditor.cmU = true;
        pbEditor2 = this.cmY.cmW;
        pbEditor2.cmO.getEditText().requestFocus();
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.ae
    public void amo() {
    }
}
