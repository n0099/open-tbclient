package com.baidu.tieba.pb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ce implements com.baidu.tieba.editortool.o {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PbEditor f2094a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(PbEditor pbEditor) {
        this.f2094a = pbEditor;
    }

    @Override // com.baidu.tieba.editortool.o
    public void a() {
        this.f2094a.b.getEditText().requestFocus();
        this.f2094a.c.c(this.f2094a.b.getEditText());
        this.f2094a.b.getEditText().setSelection(this.f2094a.b.getEditText().getText().length());
    }

    @Override // com.baidu.tieba.editortool.o
    public void b() {
    }
}
