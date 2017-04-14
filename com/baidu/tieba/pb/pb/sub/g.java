package com.baidu.tieba.pb.pb.sub;

import com.baidu.tieba.pb.pb.sub.a;
import com.baidu.tieba.pb.pb.sub.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.InterfaceC0067a {
    final /* synthetic */ b esC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar) {
        this.esC = bVar;
    }

    @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0067a
    public void aOg() {
        a aVar;
        b.a aVar2;
        b.a aVar3;
        a aVar4;
        aVar = this.esC.esw;
        if (aVar != null) {
            aVar4 = this.esC.esw;
            aVar4.setVisibility(8);
        }
        this.esC.esA = false;
        aVar2 = this.esC.esz;
        if (aVar2 != null) {
            aVar3 = this.esC.esz;
            aVar3.aOl();
        }
    }
}
