package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class at implements cq {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // com.baidu.tieba.pb.cq
    public void a(com.baidu.tieba.data.aw awVar) {
        com.baidu.tieba.model.ba baVar;
        com.baidu.tieba.model.ba baVar2;
        bk bkVar;
        baVar = this.a.n;
        if (baVar != null) {
            baVar2 = this.a.n;
            if (baVar2.e()) {
                bkVar = this.a.p;
                bkVar.s();
            }
        }
    }
}
