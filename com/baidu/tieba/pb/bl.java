package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class bl implements com.baidu.tieba.view.az {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2096a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(NewPbActivity newPbActivity) {
        this.f2096a = newPbActivity;
    }

    @Override // com.baidu.tieba.view.az
    public void a(boolean z) {
        boolean z2;
        com.baidu.tieba.model.bm bmVar;
        com.baidu.tieba.model.bm bmVar2;
        cp cpVar;
        z2 = this.f2096a.e;
        if (!z2 && z) {
            bmVar = this.f2096a.s;
            if (!bmVar.j()) {
                bmVar2 = this.f2096a.s;
                if (bmVar2.o()) {
                    cpVar = this.f2096a.y;
                    cpVar.o();
                }
            }
        }
    }
}
