package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class as extends com.baidu.adp.a.g {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        cu cuVar;
        com.baidu.tieba.model.s sVar;
        com.baidu.tieba.model.s sVar2;
        com.baidu.tieba.model.s sVar3;
        com.baidu.tieba.model.bb bbVar;
        if (obj != null) {
            sVar2 = this.a.B;
            switch (sVar2.getLoadDataMode()) {
                case 0:
                    bbVar = this.a.w;
                    bbVar.w();
                    this.a.a((com.baidu.tieba.model.u) obj);
                    return;
                case 1:
                    this.a.a((com.baidu.tieba.model.w) obj);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    NewPbActivity newPbActivity = this.a;
                    sVar3 = this.a.B;
                    newPbActivity.a(sVar3.getLoadDataMode(), (com.baidu.tieba.model.y) obj);
                    return;
                case 6:
                    this.a.a((com.baidu.tieba.model.y) obj);
                    return;
                default:
                    return;
            }
        }
        cuVar = this.a.C;
        sVar = this.a.B;
        cuVar.a(sVar.getLoadDataMode(), false, (String) null, false);
    }
}
