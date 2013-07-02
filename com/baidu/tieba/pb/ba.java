package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class ba implements com.baidu.tieba.model.ay {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // com.baidu.tieba.model.ay
    public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.data.aj ajVar, String str) {
        bk bkVar;
        bk bkVar2;
        com.baidu.tieba.model.am amVar;
        bk bkVar3;
        com.baidu.tieba.model.ax axVar;
        bk bkVar4;
        bk bkVar5;
        bk bkVar6;
        com.baidu.tieba.model.ax axVar2;
        if (z && ajVar != null) {
            amVar = this.a.k;
            amVar.a(ajVar.g());
            bkVar3 = this.a.p;
            axVar = this.a.j;
            bkVar3.a(ajVar, i2, i3, axVar.c());
            bkVar4 = this.a.p;
            bkVar4.a(ajVar, false);
            bkVar5 = this.a.p;
            bkVar5.R();
            bkVar6 = this.a.p;
            axVar2 = this.a.j;
            bkVar6.c(axVar2.b());
        } else if (str != null) {
            bkVar = this.a.p;
            bkVar.p();
            bkVar2 = this.a.p;
            bkVar2.d(str);
            if (i == 4 || i == 28) {
                this.a.finish();
            }
        }
    }

    @Override // com.baidu.tieba.model.ay
    public void a(com.baidu.tieba.data.aj ajVar) {
        bk bkVar;
        bkVar = this.a.p;
        bkVar.a(ajVar);
    }
}
