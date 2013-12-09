package com.baidu.tieba.pb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cg implements com.baidu.tieba.editortool.o {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f2204a;
    final /* synthetic */ PbEditor b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cg(PbEditor pbEditor, int i) {
        this.b = pbEditor;
        this.f2204a = i;
    }

    @Override // com.baidu.tieba.editortool.o
    public void a() {
        this.b.a(this.f2204a, null);
    }

    @Override // com.baidu.tieba.editortool.o
    public void b() {
    }
}
