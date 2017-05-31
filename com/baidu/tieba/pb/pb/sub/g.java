package com.baidu.tieba.pb.pb.sub;

import com.baidu.tieba.pb.pb.sub.a;
import com.baidu.tieba.pb.pb.sub.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.InterfaceC0073a {
    final /* synthetic */ b exL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar) {
        this.exL = bVar;
    }

    @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0073a
    public void aNF() {
        a aVar;
        b.a aVar2;
        b.a aVar3;
        a aVar4;
        aVar = this.exL.exG;
        if (aVar != null) {
            aVar4 = this.exL.exG;
            aVar4.setVisibility(8);
        }
        this.exL.exJ = false;
        aVar2 = this.exL.exI;
        if (aVar2 != null) {
            aVar3 = this.exL.exI;
            aVar3.aNK();
        }
    }
}
