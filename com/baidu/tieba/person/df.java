package com.baidu.tieba.person;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class df implements com.baidu.adp.widget.ListView.x {
    final /* synthetic */ ct a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public df(ct ctVar) {
        this.a = ctVar;
    }

    @Override // com.baidu.adp.widget.ListView.x
    public void g_() {
        com.baidu.tieba.model.av avVar;
        bd bdVar;
        bd bdVar2;
        if (!this.a.a()) {
            avVar = this.a.e;
            if (avVar.e()) {
                bdVar2 = this.a.l;
                bdVar2.b();
                return;
            }
            this.a.a(true);
            bdVar = this.a.l;
            bdVar.d();
            this.a.o();
        }
    }
}
