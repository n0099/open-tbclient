package com.baidu.tieba.tbadkCore.PbEditor;
/* loaded from: classes.dex */
class ac implements ba {
    final /* synthetic */ ab bWr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar) {
        this.bWr = abVar;
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.ba
    public void agk() {
        PbEditor pbEditor;
        PbEditor pbEditor2;
        pbEditor = this.bWr.bWp;
        pbEditor.bWn = true;
        pbEditor2 = this.bWr.bWp;
        pbEditor2.bWi.getEditText().requestFocus();
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.ba
    public void agl() {
    }
}
