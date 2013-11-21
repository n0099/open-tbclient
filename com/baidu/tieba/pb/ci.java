package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class ci implements com.baidu.tieba.editortool.o {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ch f2098a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ci(ch chVar) {
        this.f2098a = chVar;
    }

    @Override // com.baidu.tieba.editortool.o
    public void a() {
        this.f2098a.b.e = true;
        this.f2098a.b.b.getEditText().requestFocus();
    }

    @Override // com.baidu.tieba.editortool.o
    public void b() {
    }
}
