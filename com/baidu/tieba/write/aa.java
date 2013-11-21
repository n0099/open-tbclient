package com.baidu.tieba.write;
/* loaded from: classes.dex */
class aa implements com.baidu.tieba.editortool.o {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f2657a;
    final /* synthetic */ WriteActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(WriteActivity writeActivity, int i) {
        this.b = writeActivity;
        this.f2657a = i;
    }

    @Override // com.baidu.tieba.editortool.o
    public void a() {
        this.b.b(this.f2657a);
    }

    @Override // com.baidu.tieba.editortool.o
    public void b() {
    }
}
