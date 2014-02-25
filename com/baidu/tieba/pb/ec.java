package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class ec implements com.baidu.tieba.editortool.z {
    final /* synthetic */ ea a;
    private final /* synthetic */ com.baidu.tieba.editortool.z b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ec(ea eaVar, com.baidu.tieba.editortool.z zVar) {
        this.a = eaVar;
        this.b = zVar;
    }

    @Override // com.baidu.tieba.editortool.z
    public void a(int i, Object obj) {
        if (i == 0) {
            this.b.a(26, obj);
        } else if (i == 10) {
            this.b.a(27, obj);
        } else if (i == 33) {
            this.a.L.d();
            this.b.a(33, obj);
        } else if (i == 34) {
            this.a.q.setEnabled(true);
        } else {
            this.b.a(i, obj);
        }
    }
}
