package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes.dex */
class ah implements PbActivity.c {
    final /* synthetic */ PbActivity dPF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(PbActivity pbActivity) {
        this.dPF = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.PbActivity.c
    public void hu(boolean z) {
        dg dgVar;
        es esVar;
        dg dgVar2;
        es esVar2;
        dgVar = this.dPF.dOf;
        if (dgVar.hx(true)) {
            esVar2 = this.dPF.dOO;
            esVar2.aHp();
            return;
        }
        esVar = this.dPF.dOO;
        esVar.aHL();
        dgVar2 = this.dPF.dOf;
        dgVar2.nm(1);
    }
}
