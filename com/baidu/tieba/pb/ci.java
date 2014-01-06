package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class ci implements com.baidu.tieba.editortool.z {
    final /* synthetic */ ch a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ci(ch chVar) {
        this.a = chVar;
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
