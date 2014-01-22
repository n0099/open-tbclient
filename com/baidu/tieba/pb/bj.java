package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class bj implements dv {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // com.baidu.tieba.pb.dv
    public void a(com.baidu.tieba.data.ax axVar) {
        com.baidu.tieba.model.bp bpVar;
        com.baidu.tieba.model.bp bpVar2;
        cr crVar;
        bpVar = this.a.y;
        if (bpVar != null) {
            bpVar2 = this.a.y;
            if (bpVar2.h()) {
                crVar = this.a.A;
                crVar.w();
            }
        }
    }
}
