package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class an extends com.baidu.adp.a.e {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // com.baidu.adp.a.e
    public void a(Object obj) {
        bk bkVar;
        com.baidu.tieba.model.o oVar;
        com.baidu.tieba.model.o oVar2;
        com.baidu.tieba.model.o oVar3;
        if (obj != null) {
            oVar2 = this.a.o;
            switch (oVar2.getLoadDataMode()) {
                case 0:
                    this.a.a((com.baidu.tieba.model.q) obj);
                    return;
                case 1:
                    this.a.a((com.baidu.tieba.model.s) obj);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    NewPbActivity newPbActivity = this.a;
                    oVar3 = this.a.o;
                    newPbActivity.a(oVar3.getLoadDataMode(), (com.baidu.tieba.model.u) obj);
                    return;
                case 6:
                    this.a.a((com.baidu.tieba.model.u) obj);
                    return;
                default:
                    return;
            }
        }
        bkVar = this.a.p;
        oVar = this.a.o;
        bkVar.a(oVar.getLoadDataMode(), false, (String) null, false);
    }
}
