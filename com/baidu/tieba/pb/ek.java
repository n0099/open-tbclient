package com.baidu.tieba.pb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ek implements com.baidu.tieba.editortool.t {
    final /* synthetic */ com.baidu.tieba.editortool.t a;
    final /* synthetic */ eb b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ek(eb ebVar, com.baidu.tieba.editortool.t tVar) {
        this.b = ebVar;
        this.a = tVar;
    }

    @Override // com.baidu.tieba.editortool.t
    public void a(int i, Object obj) {
        if (i == 0) {
            this.a.a(26, obj);
        } else if (i == 10) {
            this.a.a(27, obj);
        } else if (i == 34) {
            this.b.q.setEnabled(true);
        } else if (i == 33) {
            this.b.q.setEnabled(false);
        } else {
            this.a.a(i, obj);
        }
    }
}
