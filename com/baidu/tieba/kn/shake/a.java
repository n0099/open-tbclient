package com.baidu.tieba.kn.shake;
/* loaded from: classes.dex */
class a implements h {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ShakeActivity f1312a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ShakeActivity shakeActivity) {
        this.f1312a = shakeActivity;
    }

    @Override // com.baidu.tieba.kn.shake.h
    public void a(int i, float f) {
        i iVar;
        k kVar;
        j jVar;
        i iVar2;
        iVar = this.f1312a.g;
        iVar.a(i);
        if (i == 1) {
            iVar2 = this.f1312a.g;
            if (!iVar2.b()) {
                this.f1312a.d();
            }
        }
        if (i % 2 == 0) {
            kVar = this.f1312a.j;
            kVar.a();
            jVar = this.f1312a.f;
            jVar.f();
        }
    }
}
