package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class bf implements com.baidu.tieba.model.bc {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1224a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(NewPbActivity newPbActivity) {
        this.f1224a = newPbActivity;
    }

    @Override // com.baidu.tieba.model.bc
    public void a(boolean z, int i, String str, com.baidu.tieba.data.aw awVar) {
        bk bkVar;
        bk bkVar2;
        bk bkVar3;
        com.baidu.tieba.model.ax axVar;
        com.baidu.tieba.model.ax axVar2;
        bkVar = this.f1224a.p;
        bkVar.d(str);
        bkVar2 = this.f1224a.p;
        bkVar2.v();
        if (!z) {
            if (i == 4 || i == 28) {
                axVar2 = this.f1224a.j;
                if (axVar2.h()) {
                    this.f1224a.f();
                }
            }
        } else if (awVar != null) {
            bkVar3 = this.f1224a.p;
            axVar = this.f1224a.j;
            bkVar3.a(awVar, axVar.j().l());
        }
    }
}
