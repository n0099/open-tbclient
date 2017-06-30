package com.baidu.tieba.pb.pb.sub;

import com.baidu.tieba.pb.pb.sub.a;
import com.baidu.tieba.pb.pb.sub.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.InterfaceC0076a {
    final /* synthetic */ b eHj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar) {
        this.eHj = bVar;
    }

    @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0076a
    public void aRF() {
        a aVar;
        b.a aVar2;
        b.a aVar3;
        a aVar4;
        aVar = this.eHj.eHe;
        if (aVar != null) {
            aVar4 = this.eHj.eHe;
            aVar4.setVisibility(8);
        }
        this.eHj.eHh = false;
        aVar2 = this.eHj.eHg;
        if (aVar2 != null) {
            aVar3 = this.eHj.eHg;
            aVar3.aRK();
        }
    }
}
