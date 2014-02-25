package com.baidu.tieba.pb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cl implements com.baidu.tieba.editortool.z {
    final /* synthetic */ PbEditor a;
    private final /* synthetic */ com.baidu.tieba.editortool.z b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cl(PbEditor pbEditor, com.baidu.tieba.editortool.z zVar) {
        this.a = pbEditor;
        this.b = zVar;
    }

    @Override // com.baidu.tieba.editortool.z
    public void a(int i, Object obj) {
        if (i == 2) {
            this.a.b(i);
        } else if (i == 3) {
            this.a.k();
        } else if (i == 5) {
            this.a.b(i);
        } else if (i == 6) {
            this.a.k();
        } else if (i == 8) {
            this.a.b(i);
        } else if (i == 9) {
            this.a.k();
        } else if (i != 0) {
            if (i == 18) {
                if (this.a.c()) {
                    this.a.b.e();
                } else {
                    this.a.b.f();
                }
            } else if (i == 12) {
                this.b.a(35, obj);
                this.a.b.k();
                this.a.c.c(this.a.b.getEditText());
            } else if (i == 38) {
                this.a.b(i);
            }
        }
        this.b.a(i, obj);
    }
}
