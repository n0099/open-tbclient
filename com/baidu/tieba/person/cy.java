package com.baidu.tieba.person;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cy implements com.baidu.adp.widget.ListView.a {
    final /* synthetic */ cr a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cy(cr crVar) {
        this.a = crVar;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public void b() {
        ao aoVar;
        if (!this.a.a()) {
            aoVar = this.a.o;
            aoVar.e();
            this.a.a(true);
            this.a.h();
        }
    }

    @Override // com.baidu.adp.widget.ListView.a
    public void a(float f) {
        ao aoVar;
        aoVar = this.a.o;
        aoVar.a(f);
    }

    @Override // com.baidu.adp.widget.ListView.a
    public void a() {
        ao aoVar;
        aoVar = this.a.o;
        aoVar.c();
    }
}
