package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.a.f;
/* loaded from: classes.dex */
class p implements f.a {
    final /* synthetic */ PbActivity ejU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(PbActivity pbActivity) {
        this.ejU = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.a.f.a
    /* renamed from: do */
    public void mo23do(boolean z) {
        ey eyVar;
        ey eyVar2;
        this.ejU.im(z);
        eyVar = this.ejU.eiS;
        if (eyVar.aNJ() != null && z) {
            eyVar2 = this.ejU.eiS;
            eyVar2.iJ(false);
        }
    }
}
