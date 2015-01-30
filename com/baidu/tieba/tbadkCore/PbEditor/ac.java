package com.baidu.tieba.tbadkCore.PbEditor;
/* loaded from: classes.dex */
class ac implements ba {
    final /* synthetic */ ab bWs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar) {
        this.bWs = abVar;
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.ba
    public void agp() {
        PbEditor pbEditor;
        PbEditor pbEditor2;
        pbEditor = this.bWs.bWq;
        pbEditor.bWo = true;
        pbEditor2 = this.bWs.bWq;
        pbEditor2.bWj.getEditText().requestFocus();
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.ba
    public void agq() {
    }
}
