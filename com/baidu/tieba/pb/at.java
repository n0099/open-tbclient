package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class at implements cq {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1211a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(NewPbActivity newPbActivity) {
        this.f1211a = newPbActivity;
    }

    @Override // com.baidu.tieba.pb.cq
    public void a(com.baidu.tieba.data.aw awVar) {
        com.baidu.tieba.model.ba baVar;
        com.baidu.tieba.model.ba baVar2;
        bk bkVar;
        baVar = this.f1211a.n;
        if (baVar != null) {
            baVar2 = this.f1211a.n;
            if (baVar2.e()) {
                bkVar = this.f1211a.p;
                bkVar.s();
            }
        }
    }
}
