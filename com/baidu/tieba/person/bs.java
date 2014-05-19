package com.baidu.tieba.person;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs implements com.baidu.adp.widget.ListView.a {
    final /* synthetic */ bm a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(bm bmVar) {
        this.a = bmVar;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public void b() {
        af afVar;
        if (!this.a.a()) {
            afVar = this.a.n;
            afVar.e();
            this.a.a(true);
            this.a.h();
        }
    }

    @Override // com.baidu.adp.widget.ListView.a
    public void a(float f) {
        af afVar;
        afVar = this.a.n;
        afVar.a(f);
    }

    @Override // com.baidu.adp.widget.ListView.a
    public void a() {
        af afVar;
        afVar = this.a.n;
        afVar.c();
    }
}
