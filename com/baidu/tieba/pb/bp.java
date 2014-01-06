package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class bp implements com.baidu.tieba.view.bf {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // com.baidu.tieba.view.bf
    public void a(boolean z) {
        boolean z2;
        com.baidu.tieba.model.bm bmVar;
        com.baidu.tieba.model.bm bmVar2;
        cs csVar;
        z2 = this.a.d;
        if (!z2 && z) {
            bmVar = this.a.t;
            if (!bmVar.j()) {
                bmVar2 = this.a.t;
                if (bmVar2.o()) {
                    csVar = this.a.z;
                    csVar.p();
                }
            }
        }
    }
}
