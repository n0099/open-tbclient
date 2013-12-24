package com.baidu.tieba.pb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class em implements com.baidu.tieba.editortool.h {
    final /* synthetic */ com.baidu.tieba.editortool.h a;
    final /* synthetic */ ed b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public em(ed edVar, com.baidu.tieba.editortool.h hVar) {
        this.b = edVar;
        this.a = hVar;
    }

    @Override // com.baidu.tieba.editortool.h
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
