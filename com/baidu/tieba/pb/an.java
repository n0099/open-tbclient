package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class an extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1455a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(NewPbActivity newPbActivity) {
        this.f1455a = newPbActivity;
    }

    @Override // com.baidu.adp.a.e
    public void a(Object obj) {
        bn bnVar;
        com.baidu.tieba.model.t tVar;
        com.baidu.tieba.model.t tVar2;
        com.baidu.tieba.model.t tVar3;
        if (obj != null) {
            tVar2 = this.f1455a.o;
            switch (tVar2.getLoadDataMode()) {
                case 0:
                    this.f1455a.a((com.baidu.tieba.model.v) obj);
                    return;
                case 1:
                    this.f1455a.a((com.baidu.tieba.model.x) obj);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    NewPbActivity newPbActivity = this.f1455a;
                    tVar3 = this.f1455a.o;
                    newPbActivity.a(tVar3.getLoadDataMode(), (com.baidu.tieba.model.z) obj);
                    return;
                case 6:
                    this.f1455a.a((com.baidu.tieba.model.z) obj);
                    return;
                default:
                    return;
            }
        }
        bnVar = this.f1455a.p;
        tVar = this.f1455a.o;
        bnVar.a(tVar.getLoadDataMode(), false, (String) null, false);
    }
}
