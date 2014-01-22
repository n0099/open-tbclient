package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class ch implements com.baidu.tieba.editortool.z {
    final /* synthetic */ cg a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ch(cg cgVar) {
        this.a = cgVar;
    }

    @Override // com.baidu.tieba.editortool.z
    public void a() {
        this.a.b.e = true;
        this.a.b.b.getEditText().requestFocus();
    }

    @Override // com.baidu.tieba.editortool.z
    public void b() {
    }
}
