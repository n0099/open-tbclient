package com.baidu.tieba.personPolymeric.b;

import com.baidu.tieba.bigv.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements a.InterfaceC0060a {
    final /* synthetic */ o eVh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(o oVar) {
        this.eVh = oVar;
    }

    @Override // com.baidu.tieba.bigv.a.InterfaceC0060a
    public void a(int i, String str, long j, boolean z) {
        boolean z2;
        a aVar;
        a aVar2;
        this.eVh.jT(z);
        z2 = this.eVh.eVa;
        if (z2) {
            aVar = this.eVh.eVd;
            if (aVar != null) {
                aVar2 = this.eVh.eVd;
                aVar2.dq(true);
            }
        }
    }
}
