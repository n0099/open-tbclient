package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class as extends com.baidu.adp.a.g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2055a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(NewPbActivity newPbActivity) {
        this.f2055a = newPbActivity;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        bt btVar;
        com.baidu.tieba.model.ad adVar;
        com.baidu.tieba.model.ad adVar2;
        com.baidu.tieba.model.ad adVar3;
        com.baidu.tieba.model.bl blVar;
        if (obj != null) {
            adVar2 = this.f2055a.t;
            switch (adVar2.getLoadDataMode()) {
                case 0:
                    blVar = this.f2055a.o;
                    blVar.u();
                    this.f2055a.a((com.baidu.tieba.model.af) obj);
                    return;
                case 1:
                    this.f2055a.a((com.baidu.tieba.model.ah) obj);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    NewPbActivity newPbActivity = this.f2055a;
                    adVar3 = this.f2055a.t;
                    newPbActivity.a(adVar3.getLoadDataMode(), (com.baidu.tieba.model.aj) obj);
                    return;
                case 6:
                    this.f2055a.a((com.baidu.tieba.model.aj) obj);
                    return;
                default:
                    return;
            }
        }
        btVar = this.f2055a.u;
        adVar = this.f2055a.t;
        btVar.a(adVar.getLoadDataMode(), false, (String) null, false);
    }
}
