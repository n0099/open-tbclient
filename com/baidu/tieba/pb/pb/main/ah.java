package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes.dex */
class ah implements PbActivity.c {
    final /* synthetic */ PbActivity ebT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(PbActivity pbActivity) {
        this.ebT = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.PbActivity.c
    public void hF(boolean z) {
        dh dhVar;
        ew ewVar;
        dh dhVar2;
        ew ewVar2;
        dhVar = this.ebT.eas;
        if (dhVar.hI(true)) {
            ewVar2 = this.ebT.ebb;
            ewVar2.aKA();
            return;
        }
        ewVar = this.ebT.ebb;
        ewVar.aFN();
        dhVar2 = this.ebT.eas;
        dhVar2.nE(1);
    }
}
