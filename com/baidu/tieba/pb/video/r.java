package com.baidu.tieba.pb.video;

import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.play.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements c.f {
    final /* synthetic */ g esY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(g gVar) {
        this.esY = gVar;
    }

    @Override // com.baidu.tieba.play.c.f
    public void aNQ() {
        bk bkVar;
        bk bkVar2;
        bk bkVar3;
        bk bkVar4;
        bk bkVar5;
        bkVar = this.esY.esP;
        if (bkVar != null) {
            long j = 0;
            bkVar2 = this.esY.esP;
            if (bkVar2.sC() != null) {
                bkVar5 = this.esY.esP;
                j = bkVar5.sC().channelId;
            }
            this.esY.JU();
            as asVar = new as("c10795");
            bkVar3 = this.esY.esP;
            as aa = asVar.aa("tid", bkVar3.getTid());
            bkVar4 = this.esY.esP;
            TiebaStatic.log(aa.g("fid", bkVar4.getFid()).g("obj_id", j));
        }
    }
}
