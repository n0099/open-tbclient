package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class bn implements com.baidu.tieba.view.ba {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2188a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(NewPbActivity newPbActivity) {
        this.f2188a = newPbActivity;
    }

    @Override // com.baidu.tieba.view.ba
    public void a(boolean z) {
        boolean z2;
        com.baidu.tieba.model.bm bmVar;
        com.baidu.tieba.model.bm bmVar2;
        cr crVar;
        z2 = this.f2188a.e;
        if (!z2 && z) {
            bmVar = this.f2188a.s;
            if (!bmVar.j()) {
                bmVar2 = this.f2188a.s;
                if (bmVar2.o()) {
                    crVar = this.f2188a.y;
                    crVar.o();
                }
            }
        }
    }
}
