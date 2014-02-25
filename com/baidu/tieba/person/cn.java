package com.baidu.tieba.person;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cn implements com.baidu.adp.widget.ListView.r {
    final /* synthetic */ cm a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cn(cm cmVar) {
        this.a = cmVar;
    }

    @Override // com.baidu.adp.widget.ListView.r
    public void a() {
        com.baidu.tieba.model.bp bpVar;
        bj bjVar;
        bj bjVar2;
        if (!this.a.a()) {
            bpVar = this.a.c;
            if (bpVar.b()) {
                bjVar2 = this.a.m;
                bjVar2.b();
                return;
            }
            this.a.a(true);
            bjVar = this.a.m;
            bjVar.g();
            this.a.k();
        }
    }
}
