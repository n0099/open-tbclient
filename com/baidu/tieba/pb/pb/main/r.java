package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.a.f;
/* loaded from: classes.dex */
class r implements f.a {
    final /* synthetic */ PbActivity enc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(PbActivity pbActivity) {
        this.enc = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.a.f.a
    public void dQ(boolean z) {
        fx fxVar;
        fx fxVar2;
        this.enc.ik(z);
        fxVar = this.enc.elU;
        if (fxVar.aMS() != null && z) {
            fxVar2 = this.enc.elU;
            fxVar2.iO(false);
        }
    }
}
