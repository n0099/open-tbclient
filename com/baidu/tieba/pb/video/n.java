package com.baidu.tieba.pb.video;

import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.play.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements c.f {
    final /* synthetic */ l eAW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar) {
        this.eAW = lVar;
    }

    @Override // com.baidu.tieba.play.c.f
    public void aOZ() {
        bl blVar;
        bl blVar2;
        bl blVar3;
        bl blVar4;
        bl blVar5;
        blVar = this.eAW.eAB;
        if (blVar != null) {
            long j = 0;
            blVar2 = this.eAW.eAB;
            if (blVar2.sx() != null) {
                blVar5 = this.eAW.eAB;
                j = blVar5.sx().channelId;
            }
            this.eAW.UA();
            as asVar = new as("c10795");
            blVar3 = this.eAW.eAB;
            as Z = asVar.Z("tid", blVar3.getTid());
            blVar4 = this.eAW.eAB;
            TiebaStatic.log(Z.f("fid", blVar4.getFid()).f("obj_id", j));
        }
    }
}
