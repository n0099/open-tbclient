package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class ci implements com.baidu.tieba.editortool.o {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ch f2205a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ci(ch chVar) {
        this.f2205a = chVar;
    }

    @Override // com.baidu.tieba.editortool.o
    public void a() {
        this.f2205a.b.e = true;
        this.f2205a.b.b.getEditText().requestFocus();
    }

    @Override // com.baidu.tieba.editortool.o
    public void b() {
    }
}
