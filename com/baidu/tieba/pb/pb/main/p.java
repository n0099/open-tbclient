package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.a.f;
/* loaded from: classes.dex */
class p implements f.a {
    final /* synthetic */ PbActivity ebT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(PbActivity pbActivity) {
        this.ebT = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.a.f.a
    public void hE(boolean z) {
        ew ewVar;
        ew ewVar2;
        this.ebT.hD(z);
        ewVar = this.ebT.ebb;
        if (ewVar.aLc() != null && z) {
            ewVar2 = this.ebT.ebb;
            ewVar2.hX(false);
        }
    }
}
