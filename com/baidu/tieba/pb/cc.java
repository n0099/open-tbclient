package com.baidu.tieba.pb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cc implements com.baidu.tieba.editortool.o {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PbEditor f2109a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(PbEditor pbEditor) {
        this.f2109a = pbEditor;
    }

    @Override // com.baidu.tieba.editortool.o
    public void a() {
        this.f2109a.b.getEditText().requestFocus();
        this.f2109a.c.c(this.f2109a.b.getEditText());
        this.f2109a.b.getEditText().setSelection(this.f2109a.b.getEditText().getText().length());
    }

    @Override // com.baidu.tieba.editortool.o
    public void b() {
    }
}
