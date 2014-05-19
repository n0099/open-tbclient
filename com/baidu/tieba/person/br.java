package com.baidu.tieba.person;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class br implements com.baidu.adp.widget.ListView.u {
    final /* synthetic */ bm a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(bm bmVar) {
        this.a = bmVar;
    }

    @Override // com.baidu.adp.widget.ListView.u
    public void f_() {
        com.baidu.tieba.model.av avVar;
        aj ajVar;
        aj ajVar2;
        if (!this.a.a()) {
            avVar = this.a.c;
            if (avVar.b()) {
                ajVar2 = this.a.k;
                ajVar2.c();
                return;
            }
            this.a.a(true);
            ajVar = this.a.k;
            ajVar.h();
            this.a.n();
        }
    }
}
