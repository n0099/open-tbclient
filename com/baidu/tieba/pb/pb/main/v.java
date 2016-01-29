package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes.dex */
class v implements PbActivity.c {
    final /* synthetic */ PbActivity cNq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(PbActivity pbActivity) {
        this.cNq = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.PbActivity.c
    public void fp(boolean z) {
        cm cmVar;
        dz dzVar;
        cm cmVar2;
        dz dzVar2;
        cmVar = this.cNq.cMF;
        if (cmVar.fs(true)) {
            dzVar2 = this.cNq.cMK;
            dzVar2.arj();
            return;
        }
        dzVar = this.cNq.cMK;
        dzVar.arE();
        cmVar2 = this.cNq.cMF;
        cmVar2.kQ(1);
    }
}
