package com.baidu.tieba.pb.main;

import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class h implements com.baidu.adp.widget.ListView.f {
    final /* synthetic */ PbActivity bvg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PbActivity pbActivity) {
        this.bvg = pbActivity;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public void H(boolean z) {
        bn bnVar;
        bv bvVar;
        bnVar = this.bvg.buG;
        if (!bnVar.ea(true)) {
            bvVar = this.bvg.buL;
            bvVar.XE();
            return;
        }
        TiebaStatic.eventStat(this.bvg, "pb_pulldown", "pbclick", 1, new Object[0]);
    }
}
