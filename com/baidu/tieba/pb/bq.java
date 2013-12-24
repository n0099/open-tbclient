package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class bq implements cm {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // com.baidu.tieba.pb.cm
    public void a(String str) {
        cr crVar;
        cr crVar2;
        if (!com.baidu.tieba.util.bc.c(str)) {
            crVar = this.a.x;
            if (com.baidu.tieba.util.bc.c(crVar.J())) {
                crVar2 = this.a.x;
                crVar2.d(str);
            }
        }
    }
}
