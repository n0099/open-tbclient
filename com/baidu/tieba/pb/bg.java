package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class bg implements dv {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2091a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(NewPbActivity newPbActivity) {
        this.f2091a = newPbActivity;
    }

    @Override // com.baidu.tieba.pb.dv
    public void a(com.baidu.tieba.data.aw awVar) {
        com.baidu.tieba.model.bp bpVar;
        com.baidu.tieba.model.bp bpVar2;
        cp cpVar;
        bpVar = this.f2091a.w;
        if (bpVar != null) {
            bpVar2 = this.f2091a.w;
            if (bpVar2.h()) {
                cpVar = this.f2091a.y;
                cpVar.v();
            }
        }
    }
}
