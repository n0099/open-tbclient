package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class ec implements com.baidu.tieba.editortool.t {
    final /* synthetic */ com.baidu.tieba.editortool.t a;
    final /* synthetic */ ea b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ec(ea eaVar, com.baidu.tieba.editortool.t tVar) {
        this.b = eaVar;
        this.a = tVar;
    }

    @Override // com.baidu.tieba.editortool.t
    public void a(int i, Object obj) {
        if (i == 0) {
            this.a.a(26, obj);
        } else if (i == 10) {
            this.a.a(27, obj);
        } else if (i == 33) {
            this.b.L.d();
            this.a.a(33, obj);
        } else if (i == 34) {
            this.b.q.setEnabled(true);
        } else {
            this.a.a(i, obj);
        }
    }
}
