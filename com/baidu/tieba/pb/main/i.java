package com.baidu.tieba.pb.main;

import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class i implements com.baidu.adp.widget.ListView.aa {
    final /* synthetic */ PbActivity bvu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(PbActivity pbActivity) {
        this.bvu = pbActivity;
    }

    @Override // com.baidu.adp.widget.ListView.aa
    public void hQ() {
        bn bnVar;
        bv bvVar;
        bn bnVar2;
        bv bvVar2;
        bnVar = this.bvu.buU;
        if (bnVar.dZ(false)) {
            bvVar2 = this.bvu.buZ;
            bvVar2.XE();
            TiebaStatic.eventStat(this.bvu, "pb_more", "pbclick", 1, new Object[0]);
            return;
        }
        bvVar = this.bvu.buZ;
        bnVar2 = this.bvu.buU;
        bvVar.h(bnVar2.getPbData());
    }
}
