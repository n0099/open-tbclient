package com.baidu.tieba.pb.video;

import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.play.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements c.f {
    final /* synthetic */ l eKu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar) {
        this.eKu = lVar;
    }

    @Override // com.baidu.tieba.play.c.f
    public void aSY() {
        bm bmVar;
        bm bmVar2;
        bm bmVar3;
        bm bmVar4;
        bm bmVar5;
        bmVar = this.eKu.eJZ;
        if (bmVar != null) {
            long j = 0;
            bmVar2 = this.eKu.eJZ;
            if (bmVar2.sv() != null) {
                bmVar5 = this.eKu.eJZ;
                j = bmVar5.sv().channelId;
            }
            this.eKu.VR();
            au auVar = new au("c10795");
            bmVar3 = this.eKu.eJZ;
            au Z = auVar.Z("tid", bmVar3.getTid());
            bmVar4 = this.eKu.eJZ;
            TiebaStatic.log(Z.f("fid", bmVar4.getFid()).f("obj_id", j));
        }
    }
}
