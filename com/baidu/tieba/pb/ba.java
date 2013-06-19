package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class ba implements com.baidu.tieba.c.ay {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // com.baidu.tieba.c.ay
    public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.a.am amVar, String str) {
        bk bkVar;
        bk bkVar2;
        com.baidu.tieba.c.ak akVar;
        bk bkVar3;
        com.baidu.tieba.c.ax axVar;
        bk bkVar4;
        bk bkVar5;
        bk bkVar6;
        com.baidu.tieba.c.ax axVar2;
        if (z && amVar != null) {
            akVar = this.a.k;
            akVar.a(amVar.g());
            bkVar3 = this.a.p;
            axVar = this.a.j;
            bkVar3.a(amVar, i2, i3, axVar.f());
            bkVar4 = this.a.p;
            bkVar4.a(amVar, false);
            bkVar5 = this.a.p;
            bkVar5.R();
            bkVar6 = this.a.p;
            axVar2 = this.a.j;
            bkVar6.b(axVar2.e());
        } else if (str != null) {
            bkVar = this.a.p;
            bkVar.q();
            bkVar2 = this.a.p;
            bkVar2.d(str);
            if (i == 4 || i == 28) {
                this.a.finish();
            }
        }
    }

    @Override // com.baidu.tieba.c.ay
    public void a(com.baidu.tieba.a.am amVar) {
        bk bkVar;
        bkVar = this.a.p;
        bkVar.a(amVar);
    }
}
