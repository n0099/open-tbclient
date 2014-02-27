package com.baidu.tieba.person;
/* loaded from: classes.dex */
final class cn implements com.baidu.adp.widget.ListView.r {
    final /* synthetic */ cm a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cn(cm cmVar) {
        this.a = cmVar;
    }

    @Override // com.baidu.adp.widget.ListView.r
    public final void b() {
        com.baidu.tieba.model.bp bpVar;
        bj bjVar;
        bj bjVar2;
        if (!this.a.a()) {
            bpVar = this.a.c;
            if (bpVar.b()) {
                bjVar2 = this.a.m;
                bjVar2.a();
                return;
            }
            this.a.a(true);
            bjVar = this.a.m;
            bjVar.e();
            this.a.c.a(false, true, 2);
        }
    }
}
