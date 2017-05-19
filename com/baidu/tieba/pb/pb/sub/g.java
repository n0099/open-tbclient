package com.baidu.tieba.pb.pb.sub;

import com.baidu.tieba.pb.pb.sub.a;
import com.baidu.tieba.pb.pb.sub.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.InterfaceC0072a {
    final /* synthetic */ b eqB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar) {
        this.eqB = bVar;
    }

    @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0072a
    public void aMw() {
        a aVar;
        b.a aVar2;
        b.a aVar3;
        a aVar4;
        aVar = this.eqB.eqw;
        if (aVar != null) {
            aVar4 = this.eqB.eqw;
            aVar4.setVisibility(8);
        }
        this.eqB.eqz = false;
        aVar2 = this.eqB.eqy;
        if (aVar2 != null) {
            aVar3 = this.eqB.eqy;
            aVar3.aMB();
        }
    }
}
