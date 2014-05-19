package com.baidu.tieba.person;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends com.baidu.adp.base.g {
    final /* synthetic */ r a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar) {
        this.a = rVar;
    }

    @Override // com.baidu.adp.base.g
    public void a(Object obj) {
        v vVar;
        v vVar2;
        t tVar;
        r.f = true;
        vVar = this.a.c;
        if (vVar != null) {
            vVar2 = this.a.c;
            tVar = this.a.d;
            vVar2.a(tVar, ((Boolean) obj).booleanValue());
        }
    }
}
