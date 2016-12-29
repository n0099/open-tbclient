package com.baidu.tieba.pb.pb.sub;

import com.baidu.tieba.pb.pb.sub.a;
import com.baidu.tieba.pb.pb.sub.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.InterfaceC0067a {
    final /* synthetic */ b ehZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar) {
        this.ehZ = bVar;
    }

    @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0067a
    public void aML() {
        a aVar;
        b.a aVar2;
        b.a aVar3;
        a aVar4;
        aVar = this.ehZ.ehT;
        if (aVar != null) {
            aVar4 = this.ehZ.ehT;
            aVar4.setVisibility(8);
        }
        this.ehZ.ehX = false;
        aVar2 = this.ehZ.ehW;
        if (aVar2 != null) {
            aVar3 = this.ehZ.ehW;
            aVar3.aMQ();
        }
    }
}
