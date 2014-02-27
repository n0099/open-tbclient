package com.baidu.tieba.pb;
/* loaded from: classes.dex */
final class ec implements com.baidu.tieba.editortool.aa {
    final /* synthetic */ ea a;
    private final /* synthetic */ com.baidu.tieba.editortool.aa b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ec(ea eaVar, com.baidu.tieba.editortool.aa aaVar) {
        this.a = eaVar;
        this.b = aaVar;
    }

    @Override // com.baidu.tieba.editortool.aa
    public final void a(int i, Object obj) {
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
