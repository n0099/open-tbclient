package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class bf implements com.baidu.tieba.c.bc {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // com.baidu.tieba.c.bc
    public void a(boolean z, int i, String str, com.baidu.tieba.a.ay ayVar) {
        bk bkVar;
        bk bkVar2;
        bk bkVar3;
        com.baidu.tieba.c.ax axVar;
        com.baidu.tieba.c.ax axVar2;
        bkVar = this.a.o;
        bkVar.d(str);
        bkVar2 = this.a.o;
        bkVar2.v();
        if (!z) {
            if (i == 4 || i == 28) {
                axVar2 = this.a.i;
                if (axVar2.k()) {
                    this.a.f();
                }
            }
        } else if (ayVar != null) {
            bkVar3 = this.a.o;
            axVar = this.a.i;
            bkVar3.a(ayVar, axVar.m().l());
        }
    }
}
