package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class ax extends com.baidu.adp.a.g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2081a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(NewPbActivity newPbActivity) {
        this.f2081a = newPbActivity;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        cp cpVar;
        com.baidu.tieba.model.ad adVar;
        com.baidu.tieba.model.ad adVar2;
        com.baidu.tieba.model.ad adVar3;
        com.baidu.tieba.model.bm bmVar;
        if (obj != null) {
            adVar2 = this.f2081a.x;
            switch (adVar2.getLoadDataMode()) {
                case 0:
                    bmVar = this.f2081a.s;
                    bmVar.v();
                    this.f2081a.a((com.baidu.tieba.model.af) obj);
                    return;
                case 1:
                    this.f2081a.a((com.baidu.tieba.model.ah) obj);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    NewPbActivity newPbActivity = this.f2081a;
                    adVar3 = this.f2081a.x;
                    newPbActivity.a(adVar3.getLoadDataMode(), (com.baidu.tieba.model.aj) obj);
                    return;
                case 6:
                    this.f2081a.a((com.baidu.tieba.model.aj) obj);
                    return;
                default:
                    return;
            }
        }
        cpVar = this.f2081a.y;
        adVar = this.f2081a.x;
        cpVar.a(adVar.getLoadDataMode(), false, (String) null, false);
    }
}
