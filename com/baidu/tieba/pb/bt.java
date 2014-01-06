package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class bt implements cm {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // com.baidu.tieba.pb.cm
    public void a(String str) {
        cs csVar;
        cs csVar2;
        if (!com.baidu.tieba.util.bm.c(str)) {
            csVar = this.a.z;
            if (com.baidu.tieba.util.bm.c(csVar.J())) {
                csVar2 = this.a.z;
                csVar2.d(str);
            }
        }
    }
}
