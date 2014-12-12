package com.baidu.tieba.tbadkCore.PbEditor;
/* loaded from: classes.dex */
class ac implements ba {
    final /* synthetic */ ab bUA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar) {
        this.bUA = abVar;
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.ba
    public void afL() {
        PbEditor pbEditor;
        PbEditor pbEditor2;
        pbEditor = this.bUA.bUy;
        pbEditor.bUw = true;
        pbEditor2 = this.bUA.bUy;
        pbEditor2.bUr.getEditText().requestFocus();
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.ba
    public void afM() {
    }
}
