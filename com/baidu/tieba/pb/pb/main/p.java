package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.a.f;
/* loaded from: classes.dex */
class p implements f.a {
    final /* synthetic */ PbActivity dPF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(PbActivity pbActivity) {
        this.dPF = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.a.f.a
    public void ht(boolean z) {
        es esVar;
        es esVar2;
        this.dPF.hs(z);
        esVar = this.dPF.dOO;
        if (esVar.aHS() != null && z) {
            esVar2 = this.dPF.dOO;
            esVar2.hL(false);
        }
    }
}
