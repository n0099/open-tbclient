package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.a.f;
/* loaded from: classes.dex */
class p implements f.a {
    final /* synthetic */ PbActivity emk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(PbActivity pbActivity) {
        this.emk = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.a.f.a
    public void dy(boolean z) {
        ey eyVar;
        ey eyVar2;
        this.emk.iw(z);
        eyVar = this.emk.eli;
        if (eyVar.aOK() != null && z) {
            eyVar2 = this.emk.eli;
            eyVar2.iT(false);
        }
    }
}
