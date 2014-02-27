package com.baidu.tieba.pb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class cl implements com.baidu.tieba.editortool.aa {
    final /* synthetic */ PbEditor a;
    private final /* synthetic */ com.baidu.tieba.editortool.aa b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cl(PbEditor pbEditor, com.baidu.tieba.editortool.aa aaVar) {
        this.a = pbEditor;
        this.b = aaVar;
    }

    @Override // com.baidu.tieba.editortool.aa
    public final void a(int i, Object obj) {
        if (i == 2) {
            this.a.b(i);
        } else if (i == 3) {
            this.a.j();
        } else if (i == 5) {
            this.a.b(i);
        } else if (i == 6) {
            this.a.j();
        } else if (i == 8) {
            this.a.b(i);
        } else if (i == 9) {
            this.a.j();
        } else if (i != 0) {
            if (i == 18) {
                if (this.a.c()) {
                    this.a.b.d();
                } else {
                    this.a.b.e();
                }
            } else if (i == 12) {
                this.b.a(35, obj);
                this.a.b.j();
                this.a.c.c(this.a.b.getEditText());
            } else if (i == 38) {
                this.a.b(i);
            }
        }
        this.b.a(i, obj);
    }
}
