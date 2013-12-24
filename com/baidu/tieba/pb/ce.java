package com.baidu.tieba.pb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ce implements com.baidu.tieba.editortool.o {
    final /* synthetic */ PbEditor a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(PbEditor pbEditor) {
        this.a = pbEditor;
    }

    @Override // com.baidu.tieba.editortool.o
    public void a() {
        this.a.b.getEditText().requestFocus();
        this.a.c.c(this.a.b.getEditText());
        this.a.b.getEditText().setSelection(this.a.b.getEditText().getText().length());
    }

    @Override // com.baidu.tieba.editortool.o
    public void b() {
    }
}
