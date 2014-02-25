package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class ck implements com.baidu.tieba.editortool.ae {
    final /* synthetic */ cj a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ck(cj cjVar) {
        this.a = cjVar;
    }

    @Override // com.baidu.tieba.editortool.ae
    public void a() {
        PbEditor pbEditor;
        PbEditor pbEditor2;
        pbEditor = this.a.a;
        pbEditor.e = true;
        pbEditor2 = this.a.a;
        pbEditor2.b.getEditText().requestFocus();
    }

    @Override // com.baidu.tieba.editortool.ae
    public void b() {
    }
}
