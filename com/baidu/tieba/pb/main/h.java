package com.baidu.tieba.pb.main;

import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class h implements com.baidu.adp.widget.ListView.f {
    final /* synthetic */ PbActivity bvu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PbActivity pbActivity) {
        this.bvu = pbActivity;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public void H(boolean z) {
        bn bnVar;
        bv bvVar;
        bnVar = this.bvu.buU;
        if (!bnVar.ea(true)) {
            bvVar = this.bvu.buZ;
            bvVar.XH();
            return;
        }
        TiebaStatic.eventStat(this.bvu, "pb_pulldown", "pbclick", 1, new Object[0]);
    }
}
