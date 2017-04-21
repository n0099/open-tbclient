package com.baidu.tieba.pb.pb.sub;

import com.baidu.tieba.pb.pb.sub.a;
import com.baidu.tieba.pb.pb.sub.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.InterfaceC0067a {
    final /* synthetic */ b euT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar) {
        this.euT = bVar;
    }

    @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0067a
    public void aPh() {
        a aVar;
        b.a aVar2;
        b.a aVar3;
        a aVar4;
        aVar = this.euT.euO;
        if (aVar != null) {
            aVar4 = this.euT.euO;
            aVar4.setVisibility(8);
        }
        this.euT.euR = false;
        aVar2 = this.euT.euQ;
        if (aVar2 != null) {
            aVar3 = this.euT.euQ;
            aVar3.aPm();
        }
    }
}
