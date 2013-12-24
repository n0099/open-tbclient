package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class bj implements dx {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // com.baidu.tieba.pb.dx
    public void a(com.baidu.tieba.data.av avVar) {
        com.baidu.tieba.model.bp bpVar;
        com.baidu.tieba.model.bp bpVar2;
        cr crVar;
        bpVar = this.a.v;
        if (bpVar != null) {
            bpVar2 = this.a.v;
            if (bpVar2.h()) {
                crVar = this.a.x;
                crVar.v();
            }
        }
    }
}
