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
        com.baidu.tieba.c.l lVar;
        com.baidu.tieba.c.l lVar2;
        com.baidu.tieba.c.l lVar3;
        if (obj != null) {
            lVar2 = this.a.n;
            switch (lVar2.a()) {
                case 0:
                    this.a.a((com.baidu.tieba.c.n) obj);
                    return;
                case 1:
                    this.a.a((com.baidu.tieba.c.p) obj);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    NewPbActivity newPbActivity = this.a;
                    lVar3 = this.a.n;
                    newPbActivity.a(lVar3.a(), (com.baidu.tieba.c.r) obj);
                    return;
                case 6:
                    this.a.a((com.baidu.tieba.c.r) obj);
                    return;
                default:
                    return;
            }
        }
        bkVar = this.a.o;
        lVar = this.a.n;
        bkVar.a(lVar.a(), false, (String) null, false);
    }
}
