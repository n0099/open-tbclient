package com.baidu.tieba.pb.main;

import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class i implements com.baidu.adp.widget.ListView.aa {
    final /* synthetic */ PbActivity bvg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(PbActivity pbActivity) {
        this.bvg = pbActivity;
    }

    @Override // com.baidu.adp.widget.ListView.aa
    public void hQ() {
        bn bnVar;
        bv bvVar;
        bn bnVar2;
        bv bvVar2;
        bnVar = this.bvg.buG;
        if (bnVar.dZ(false)) {
            bvVar2 = this.bvg.buL;
            bvVar2.XB();
            TiebaStatic.eventStat(this.bvg, "pb_more", "pbclick", 1, new Object[0]);
            return;
        }
        bvVar = this.bvg.buL;
        bnVar2 = this.bvg.buG;
        bvVar.h(bnVar2.getPbData());
    }
}
