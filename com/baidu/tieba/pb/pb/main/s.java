package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.a.f;
/* loaded from: classes.dex */
class s implements f.a {
    final /* synthetic */ PbActivity ewh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(PbActivity pbActivity) {
        this.ewh = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.a.f.a
    public void eg(boolean z) {
        gg ggVar;
        gg ggVar2;
        this.ewh.iG(z);
        ggVar = this.ewh.euU;
        if (ggVar.aQQ() != null && z) {
            ggVar2 = this.ewh.euU;
            ggVar2.jk(false);
        }
    }
}
