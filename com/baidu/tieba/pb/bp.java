package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class bp implements com.baidu.tieba.view.br {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // com.baidu.tieba.view.br
    public void a(boolean z) {
        boolean z2;
        com.baidu.tieba.model.bm bmVar;
        com.baidu.tieba.model.bm bmVar2;
        cr crVar;
        z2 = this.a.d;
        if (!z2 && z) {
            bmVar = this.a.u;
            if (!bmVar.j()) {
                bmVar2 = this.a.u;
                if (bmVar2.o()) {
                    crVar = this.a.A;
                    crVar.p();
                }
            }
        }
    }
}
