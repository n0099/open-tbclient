package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.a.f;
/* loaded from: classes.dex */
class p implements f.a {
    final /* synthetic */ PbActivity elO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(PbActivity pbActivity) {
        this.elO = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.a.f.a
    public void dm(boolean z) {
        fa faVar;
        fa faVar2;
        this.elO.in(z);
        faVar = this.elO.ekM;
        if (faVar.aNA() != null && z) {
            faVar2 = this.elO.ekM;
            faVar2.iK(false);
        }
    }
}
