package com.baidu.tieba.pb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cn implements com.baidu.tieba.editortool.h {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.baidu.tieba.editortool.h f2210a;
    final /* synthetic */ PbEditorToolView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cn(PbEditorToolView pbEditorToolView, com.baidu.tieba.editortool.h hVar) {
        this.b = pbEditorToolView;
        this.f2210a = hVar;
    }

    @Override // com.baidu.tieba.editortool.h
    public void a(int i, Object obj) {
        if (i == 5) {
            this.b.h();
            this.b.c.h();
        } else if (i == 6) {
            this.b.h();
            this.b.c.c();
        } else if (i == 0) {
            this.b.h();
        } else if (i == 2) {
            this.b.h();
            this.b.c.f();
        } else if (i == 3) {
            this.b.h();
            this.b.c.c();
        } else if (i == 8) {
            this.b.h();
            this.b.c.g();
        } else if (i == 9) {
            this.b.h();
            this.b.c.c();
        }
        this.f2210a.a(i, obj);
    }
}
