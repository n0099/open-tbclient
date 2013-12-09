package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class bj implements dx {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2185a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(NewPbActivity newPbActivity) {
        this.f2185a = newPbActivity;
    }

    @Override // com.baidu.tieba.pb.dx
    public void a(com.baidu.tieba.data.av avVar) {
        com.baidu.tieba.model.bp bpVar;
        com.baidu.tieba.model.bp bpVar2;
        cr crVar;
        bpVar = this.f2185a.w;
        if (bpVar != null) {
            bpVar2 = this.f2185a.w;
            if (bpVar2.h()) {
                crVar = this.f2185a.y;
                crVar.v();
            }
        }
    }
}
