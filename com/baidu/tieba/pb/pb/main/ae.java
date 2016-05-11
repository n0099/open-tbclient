package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes.dex */
class ae implements PbActivity.c {
    final /* synthetic */ PbActivity djE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(PbActivity pbActivity) {
        this.djE = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.PbActivity.c
    public void gB(boolean z) {
        cw cwVar;
        el elVar;
        cw cwVar2;
        el elVar2;
        cwVar = this.djE.dih;
        if (cwVar.gF(true)) {
            elVar2 = this.djE.diR;
            elVar2.azc();
            return;
        }
        elVar = this.djE.diR;
        elVar.azx();
        cwVar2 = this.djE.dih;
        cwVar2.lO(1);
    }
}
