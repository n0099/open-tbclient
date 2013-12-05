package com.baidu.tieba.write;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements com.baidu.tieba.editortool.o {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f2775a;
    final /* synthetic */ WriteActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(WriteActivity writeActivity, int i) {
        this.b = writeActivity;
        this.f2775a = i;
    }

    @Override // com.baidu.tieba.editortool.o
    public void a() {
        this.b.b(this.f2775a);
    }

    @Override // com.baidu.tieba.editortool.o
    public void b() {
    }
}
