package com.baidu.tieba.pb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ce implements com.baidu.tieba.editortool.o {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f2111a;
    final /* synthetic */ PbEditor b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(PbEditor pbEditor, int i) {
        this.b = pbEditor;
        this.f2111a = i;
    }

    @Override // com.baidu.tieba.editortool.o
    public void a() {
        this.b.a(this.f2111a, null);
    }

    @Override // com.baidu.tieba.editortool.o
    public void b() {
    }
}
