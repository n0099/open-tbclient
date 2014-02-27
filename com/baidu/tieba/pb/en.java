package com.baidu.tieba.pb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class en implements com.baidu.tieba.editortool.aa {
    final /* synthetic */ ed a;
    private final /* synthetic */ com.baidu.tieba.editortool.aa b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public en(ed edVar, com.baidu.tieba.editortool.aa aaVar) {
        this.a = edVar;
        this.b = aaVar;
    }

    @Override // com.baidu.tieba.editortool.aa
    public final void a(int i, Object obj) {
        if (i == 0) {
            this.b.a(26, obj);
        } else if (i == 10) {
            this.b.a(27, obj);
        } else if (i == 34) {
            this.a.q.setEnabled(true);
        } else if (i == 33) {
            this.a.q.setEnabled(false);
        } else {
            this.b.a(i, obj);
        }
    }
}
