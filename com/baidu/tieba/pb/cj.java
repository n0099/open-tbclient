package com.baidu.tieba.pb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cj implements com.baidu.tieba.editortool.h {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.baidu.tieba.editortool.h f2206a;
    final /* synthetic */ PbEditor b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cj(PbEditor pbEditor, com.baidu.tieba.editortool.h hVar) {
        this.b = pbEditor;
        this.f2206a = hVar;
    }

    @Override // com.baidu.tieba.editortool.h
    public void a(int i, Object obj) {
        if (i == 2) {
            this.b.c(i);
        } else if (i == 3) {
            this.b.l();
        } else if (i == 5) {
            this.b.c(i);
        } else if (i == 6) {
            this.b.l();
        } else if (i == 8) {
            this.b.c(i);
        } else if (i == 9) {
            this.b.l();
        } else if (i != 0) {
            if (i == 18) {
                if (this.b.c()) {
                    this.b.b.f();
                } else {
                    this.b.b.g();
                }
            } else if (i == 12) {
                this.f2206a.a(33, obj);
                this.b.b.l();
                this.b.c.c(this.b.b.getEditText());
            }
        }
        this.f2206a.a(i, obj);
    }
}
