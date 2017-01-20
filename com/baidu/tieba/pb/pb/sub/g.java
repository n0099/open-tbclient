package com.baidu.tieba.pb.pb.sub;

import com.baidu.tieba.pb.pb.sub.a;
import com.baidu.tieba.pb.pb.sub.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.InterfaceC0069a {
    final /* synthetic */ b erj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar) {
        this.erj = bVar;
    }

    @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0069a
    public void aOG() {
        a aVar;
        b.a aVar2;
        b.a aVar3;
        a aVar4;
        aVar = this.erj.erd;
        if (aVar != null) {
            aVar4 = this.erj.erd;
            aVar4.setVisibility(8);
        }
        this.erj.erh = false;
        aVar2 = this.erj.erg;
        if (aVar2 != null) {
            aVar3 = this.erj.erg;
            aVar3.aOL();
        }
    }
}
