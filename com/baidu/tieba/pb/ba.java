package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class ba implements com.baidu.tieba.c.av {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // com.baidu.tieba.c.av
    public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.a.al alVar, String str) {
        bl blVar;
        bl blVar2;
        com.baidu.tieba.c.ah ahVar;
        bl blVar3;
        com.baidu.tieba.c.au auVar;
        bl blVar4;
        bl blVar5;
        bl blVar6;
        com.baidu.tieba.c.au auVar2;
        if (z && alVar != null) {
            ahVar = this.a.j;
            ahVar.a(alVar.g());
            blVar3 = this.a.o;
            auVar = this.a.i;
            blVar3.a(alVar, i2, i3, auVar.f());
            blVar4 = this.a.o;
            blVar4.a(alVar, false);
            blVar5 = this.a.o;
            blVar5.Q();
            blVar6 = this.a.o;
            auVar2 = this.a.i;
            blVar6.b(auVar2.e());
        } else if (str != null) {
            blVar = this.a.o;
            blVar.q();
            blVar2 = this.a.o;
            blVar2.d(str);
            if (i == 4 || i == 28) {
                this.a.f();
            }
        }
    }

    @Override // com.baidu.tieba.c.av
    public void a(com.baidu.tieba.a.al alVar) {
        bl blVar;
        blVar = this.a.o;
        blVar.a(alVar);
    }
}
