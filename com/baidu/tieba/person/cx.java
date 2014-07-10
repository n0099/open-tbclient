package com.baidu.tieba.person;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cx implements com.baidu.adp.widget.ListView.x {
    final /* synthetic */ cr a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cx(cr crVar) {
        this.a = crVar;
    }

    @Override // com.baidu.adp.widget.ListView.x
    public void g_() {
        com.baidu.tieba.model.au auVar;
        az azVar;
        az azVar2;
        if (!this.a.a()) {
            auVar = this.a.e;
            if (auVar.d()) {
                azVar2 = this.a.l;
                azVar2.c();
                return;
            }
            this.a.a(true);
            azVar = this.a.l;
            azVar.e();
            this.a.l();
        }
    }
}
