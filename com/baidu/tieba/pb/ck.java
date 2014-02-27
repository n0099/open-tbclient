package com.baidu.tieba.pb;
/* loaded from: classes.dex */
final class ck implements com.baidu.tieba.editortool.af {
    final /* synthetic */ cj a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ck(cj cjVar) {
        this.a = cjVar;
    }

    @Override // com.baidu.tieba.editortool.af
    public final void a() {
        PbEditor pbEditor;
        PbEditor pbEditor2;
        pbEditor = this.a.a;
        pbEditor.e = true;
        pbEditor2 = this.a.a;
        pbEditor2.b.getEditText().requestFocus();
    }
}
