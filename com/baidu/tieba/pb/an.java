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
        bl blVar;
        com.baidu.tieba.c.i iVar;
        com.baidu.tieba.c.i iVar2;
        com.baidu.tieba.c.i iVar3;
        if (obj != null) {
            iVar2 = this.a.n;
            switch (iVar2.a()) {
                case 0:
                    this.a.a((com.baidu.tieba.c.k) obj);
                    return;
                case 1:
                    this.a.a((com.baidu.tieba.c.m) obj);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    NewPbActivity newPbActivity = this.a;
                    iVar3 = this.a.n;
                    newPbActivity.a(iVar3.a(), (com.baidu.tieba.c.o) obj);
                    return;
                case 6:
                    this.a.a((com.baidu.tieba.c.o) obj);
                    return;
                default:
                    return;
            }
        }
        blVar = this.a.o;
        iVar = this.a.n;
        blVar.a(iVar.a(), false, (String) null, false);
    }
}
