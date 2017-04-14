package com.baidu.tieba.pb.video;

import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.play.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements c.f {
    final /* synthetic */ d euY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(d dVar) {
        this.euY = dVar;
    }

    @Override // com.baidu.tieba.play.c.f
    public void aPy() {
        bi biVar;
        bi biVar2;
        bi biVar3;
        bi biVar4;
        bi biVar5;
        biVar = this.euY.euP;
        if (biVar != null) {
            long j = 0;
            biVar2 = this.euY.euP;
            if (biVar2.ts() != null) {
                biVar5 = this.euY.euP;
                j = biVar5.ts().channelId;
            }
            this.euY.KG();
            as asVar = new as("c10795");
            biVar3 = this.euY.euP;
            as aa = asVar.aa("tid", biVar3.getTid());
            biVar4 = this.euY.euP;
            TiebaStatic.log(aa.g("fid", biVar4.getFid()).g("obj_id", j));
        }
    }
}
