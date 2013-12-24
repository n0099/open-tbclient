package com.baidu.tieba.write;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements com.baidu.tieba.editortool.o {
    final /* synthetic */ int a;
    final /* synthetic */ WriteActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(WriteActivity writeActivity, int i) {
        this.b = writeActivity;
        this.a = i;
    }

    @Override // com.baidu.tieba.editortool.o
    public void a() {
        this.b.b(this.a);
    }

    @Override // com.baidu.tieba.editortool.o
    public void b() {
    }
}
