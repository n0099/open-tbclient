package com.baidu.tieba.pb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cj implements com.baidu.tieba.editortool.t {
    final /* synthetic */ com.baidu.tieba.editortool.t a;
    final /* synthetic */ PbEditor b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cj(PbEditor pbEditor, com.baidu.tieba.editortool.t tVar) {
        this.b = pbEditor;
        this.a = tVar;
    }

    @Override // com.baidu.tieba.editortool.t
    public void a(int i, Object obj) {
        if (i == 2) {
            this.b.c(i);
        } else if (i == 3) {
            this.b.k();
        } else if (i == 5) {
            this.b.c(i);
        } else if (i == 6) {
            this.b.k();
        } else if (i == 8) {
            this.b.c(i);
        } else if (i == 9) {
            this.b.k();
        } else if (i != 0) {
            if (i == 18) {
                if (this.b.c()) {
                    this.b.b.e();
                } else {
                    this.b.b.f();
                }
            } else if (i == 12) {
                this.a.a(33, obj);
                this.b.b.i();
                this.b.c.c(this.b.b.getEditText());
            } else if (i == 36) {
                this.b.c(i);
            }
        }
        this.a.a(i, obj);
    }
}
