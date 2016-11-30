package com.baidu.tieba.pb.pb.sub;

import com.baidu.tieba.pb.pb.sub.a;
import com.baidu.tieba.pb.pb.sub.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.InterfaceC0073a {
    final /* synthetic */ b eDZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar) {
        this.eDZ = bVar;
    }

    @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0073a
    public void aSU() {
        a aVar;
        b.a aVar2;
        b.a aVar3;
        a aVar4;
        aVar = this.eDZ.eDT;
        if (aVar != null) {
            aVar4 = this.eDZ.eDT;
            aVar4.setVisibility(8);
        }
        this.eDZ.eDX = false;
        aVar2 = this.eDZ.eDW;
        if (aVar2 != null) {
            aVar3 = this.eDZ.eDW;
            aVar3.aSZ();
        }
    }
}
