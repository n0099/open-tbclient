package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class ci implements com.baidu.tieba.editortool.o {
    final /* synthetic */ ch a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ci(ch chVar) {
        this.a = chVar;
    }

    @Override // com.baidu.tieba.editortool.o
    public void a() {
        this.a.b.e = true;
        this.a.b.b.getEditText().requestFocus();
    }

    @Override // com.baidu.tieba.editortool.o
    public void b() {
    }
}
