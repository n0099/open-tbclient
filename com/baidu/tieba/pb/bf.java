package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class bf implements com.baidu.tieba.c.az {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // com.baidu.tieba.c.az
    public void a(boolean z, int i, String str, com.baidu.tieba.a.ax axVar) {
        bl blVar;
        bl blVar2;
        bl blVar3;
        com.baidu.tieba.c.au auVar;
        com.baidu.tieba.c.au auVar2;
        blVar = this.a.o;
        blVar.d(str);
        blVar2 = this.a.o;
        blVar2.v();
        if (!z) {
            if (i == 4 || i == 28) {
                auVar2 = this.a.i;
                if (auVar2.k()) {
                    this.a.f();
                }
            }
        } else if (axVar != null) {
            blVar3 = this.a.o;
            auVar = this.a.i;
            blVar3.a(axVar, auVar.l().l());
        }
    }
}
