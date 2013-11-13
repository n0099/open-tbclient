package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class cg implements com.baidu.tieba.editortool.o {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cf f2113a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cg(cf cfVar) {
        this.f2113a = cfVar;
    }

    @Override // com.baidu.tieba.editortool.o
    public void a() {
        this.f2113a.b.e = true;
        this.f2113a.b.b.getEditText().requestFocus();
    }

    @Override // com.baidu.tieba.editortool.o
    public void b() {
    }
}
