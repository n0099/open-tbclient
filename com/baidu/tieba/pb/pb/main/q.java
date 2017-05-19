package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.a.f;
/* loaded from: classes.dex */
class q implements f.a {
    final /* synthetic */ PbActivity ehy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(PbActivity pbActivity) {
        this.ehy = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.a.f.a
    public void dz(boolean z) {
        fm fmVar;
        fm fmVar2;
        this.ehy.hW(z);
        fmVar = this.ehy.egt;
        if (fmVar.aLY() != null && z) {
            fmVar2 = this.ehy.egt;
            fmVar2.iy(false);
        }
    }
}
