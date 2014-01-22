package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class bt implements cl {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // com.baidu.tieba.pb.cl
    public void a(String str) {
        cr crVar;
        cr crVar2;
        if (!com.baidu.tieba.util.bu.c(str)) {
            crVar = this.a.A;
            if (com.baidu.tieba.util.bu.c(crVar.J())) {
                crVar2 = this.a.A;
                crVar2.d(str);
            }
        }
    }
}
