package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class bn implements com.baidu.tieba.view.az {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2081a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(NewPbActivity newPbActivity) {
        this.f2081a = newPbActivity;
    }

    @Override // com.baidu.tieba.view.az
    public void a(boolean z) {
        boolean z2;
        com.baidu.tieba.model.bm bmVar;
        com.baidu.tieba.model.bm bmVar2;
        cr crVar;
        z2 = this.f2081a.e;
        if (!z2 && z) {
            bmVar = this.f2081a.s;
            if (!bmVar.j()) {
                bmVar2 = this.f2081a.s;
                if (bmVar2.o()) {
                    crVar = this.f2081a.y;
                    crVar.o();
                }
            }
        }
    }
}
