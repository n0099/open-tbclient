package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class ax extends com.baidu.adp.a.g {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        cr crVar;
        com.baidu.tieba.model.ad adVar;
        com.baidu.tieba.model.ad adVar2;
        com.baidu.tieba.model.ad adVar3;
        com.baidu.tieba.model.bm bmVar;
        if (obj != null) {
            adVar2 = this.a.w;
            switch (adVar2.getLoadDataMode()) {
                case 0:
                    bmVar = this.a.r;
                    bmVar.v();
                    this.a.a((com.baidu.tieba.model.af) obj);
                    return;
                case 1:
                    this.a.a((com.baidu.tieba.model.ah) obj);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    NewPbActivity newPbActivity = this.a;
                    adVar3 = this.a.w;
                    newPbActivity.a(adVar3.getLoadDataMode(), (com.baidu.tieba.model.aj) obj);
                    return;
                case 6:
                    this.a.a((com.baidu.tieba.model.aj) obj);
                    return;
                default:
                    return;
            }
        }
        crVar = this.a.x;
        adVar = this.a.w;
        crVar.a(adVar.getLoadDataMode(), false, (String) null, false);
    }
}
