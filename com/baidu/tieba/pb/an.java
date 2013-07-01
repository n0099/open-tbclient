package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class an extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1205a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(NewPbActivity newPbActivity) {
        this.f1205a = newPbActivity;
    }

    @Override // com.baidu.adp.a.e
    public void a(Object obj) {
        bk bkVar;
        com.baidu.tieba.model.o oVar;
        com.baidu.tieba.model.o oVar2;
        com.baidu.tieba.model.o oVar3;
        if (obj != null) {
            oVar2 = this.f1205a.o;
            switch (oVar2.getLoadDataMode()) {
                case 0:
                    this.f1205a.a((com.baidu.tieba.model.q) obj);
                    return;
                case 1:
                    this.f1205a.a((com.baidu.tieba.model.s) obj);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    NewPbActivity newPbActivity = this.f1205a;
                    oVar3 = this.f1205a.o;
                    newPbActivity.a(oVar3.getLoadDataMode(), (com.baidu.tieba.model.u) obj);
                    return;
                case 6:
                    this.f1205a.a((com.baidu.tieba.model.u) obj);
                    return;
                default:
                    return;
            }
        }
        bkVar = this.f1205a.p;
        oVar = this.f1205a.o;
        bkVar.a(oVar.getLoadDataMode(), false, (String) null, false);
    }
}
