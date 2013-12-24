package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class bn implements com.baidu.tieba.view.az {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // com.baidu.tieba.view.az
    public void a(boolean z) {
        boolean z2;
        com.baidu.tieba.model.bm bmVar;
        com.baidu.tieba.model.bm bmVar2;
        cr crVar;
        z2 = this.a.d;
        if (!z2 && z) {
            bmVar = this.a.r;
            if (!bmVar.j()) {
                bmVar2 = this.a.r;
                if (bmVar2.o()) {
                    crVar = this.a.x;
                    crVar.o();
                }
            }
        }
    }
}
