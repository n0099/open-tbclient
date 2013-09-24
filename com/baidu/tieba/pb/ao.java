package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class ao extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1534a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(NewPbActivity newPbActivity) {
        this.f1534a = newPbActivity;
    }

    @Override // com.baidu.adp.a.e
    public void a(Object obj) {
        br brVar;
        com.baidu.tieba.model.v vVar;
        com.baidu.tieba.model.v vVar2;
        com.baidu.tieba.model.v vVar3;
        com.baidu.tieba.model.bd bdVar;
        if (obj != null) {
            vVar2 = this.f1534a.s;
            switch (vVar2.getLoadDataMode()) {
                case 0:
                    bdVar = this.f1534a.n;
                    bdVar.u();
                    this.f1534a.a((com.baidu.tieba.model.x) obj);
                    return;
                case 1:
                    this.f1534a.a((com.baidu.tieba.model.z) obj);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    NewPbActivity newPbActivity = this.f1534a;
                    vVar3 = this.f1534a.s;
                    newPbActivity.a(vVar3.getLoadDataMode(), (com.baidu.tieba.model.ab) obj);
                    return;
                case 6:
                    this.f1534a.a((com.baidu.tieba.model.ab) obj);
                    return;
                default:
                    return;
            }
        }
        brVar = this.f1534a.t;
        vVar = this.f1534a.s;
        brVar.a(vVar.getLoadDataMode(), false, (String) null, false);
    }
}
