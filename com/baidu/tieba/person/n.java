package com.baidu.tieba.person;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends com.baidu.adp.base.h {
    final /* synthetic */ m a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.a = mVar;
    }

    @Override // com.baidu.adp.base.h
    public void a(Object obj) {
        q qVar;
        q qVar2;
        o oVar;
        m.f = true;
        qVar = this.a.c;
        if (qVar != null) {
            qVar2 = this.a.c;
            oVar = this.a.d;
            qVar2.a(oVar, ((Boolean) obj).booleanValue());
        }
    }
}
