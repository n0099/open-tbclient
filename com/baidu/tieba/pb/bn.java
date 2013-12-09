package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class bn implements com.baidu.tieba.view.ba {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2189a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(NewPbActivity newPbActivity) {
        this.f2189a = newPbActivity;
    }

    @Override // com.baidu.tieba.view.ba
    public void a(boolean z) {
        boolean z2;
        com.baidu.tieba.model.bm bmVar;
        com.baidu.tieba.model.bm bmVar2;
        cr crVar;
        z2 = this.f2189a.e;
        if (!z2 && z) {
            bmVar = this.f2189a.s;
            if (!bmVar.j()) {
                bmVar2 = this.f2189a.s;
                if (bmVar2.o()) {
                    crVar = this.f2189a.y;
                    crVar.o();
                }
            }
        }
    }
}
