package com.baidu.tieba.person;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends com.baidu.adp.base.h {
    final /* synthetic */ n a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.a = nVar;
    }

    @Override // com.baidu.adp.base.h
    public void a(Object obj) {
        r rVar;
        r rVar2;
        p pVar;
        n.f = true;
        rVar = this.a.c;
        if (rVar != null) {
            rVar2 = this.a.c;
            pVar = this.a.d;
            rVar2.a(pVar, ((Boolean) obj).booleanValue());
        }
    }
}
