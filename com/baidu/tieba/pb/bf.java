package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class bf implements com.baidu.tieba.model.bc {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // com.baidu.tieba.model.bc
    public void a(boolean z, int i, String str, com.baidu.tieba.data.aw awVar) {
        bk bkVar;
        bk bkVar2;
        bk bkVar3;
        com.baidu.tieba.model.ax axVar;
        com.baidu.tieba.model.ax axVar2;
        bkVar = this.a.p;
        bkVar.d(str);
        bkVar2 = this.a.p;
        bkVar2.v();
        if (!z) {
            if (i == 4 || i == 28) {
                axVar2 = this.a.j;
                if (axVar2.h()) {
                    this.a.f();
                }
            }
        } else if (awVar != null) {
            bkVar3 = this.a.p;
            axVar = this.a.j;
            bkVar3.a(awVar, axVar.j().l());
        }
    }
}
