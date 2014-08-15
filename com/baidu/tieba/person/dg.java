package com.baidu.tieba.person;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dg implements com.baidu.adp.widget.ListView.a {
    final /* synthetic */ ct a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dg(ct ctVar) {
        this.a = ctVar;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public void b() {
        an anVar;
        if (!this.a.a()) {
            anVar = this.a.o;
            anVar.g();
            this.a.a(true);
            this.a.i();
        }
    }

    @Override // com.baidu.adp.widget.ListView.a
    public void a(float f) {
        an anVar;
        anVar = this.a.o;
        anVar.a(f);
    }

    @Override // com.baidu.adp.widget.ListView.a
    public void a() {
        an anVar;
        anVar = this.a.o;
        anVar.e();
    }
}
