package com.baidu.tieba.pb.video;

import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.play.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements c.f {
    final /* synthetic */ d ewS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(d dVar) {
        this.ewS = dVar;
    }

    @Override // com.baidu.tieba.play.c.f
    public void aPp() {
        bj bjVar;
        bj bjVar2;
        bj bjVar3;
        bj bjVar4;
        bj bjVar5;
        bjVar = this.ewS.ewJ;
        if (bjVar != null) {
            long j = 0;
            bjVar2 = this.ewS.ewJ;
            if (bjVar2.sU() != null) {
                bjVar5 = this.ewS.ewJ;
                j = bjVar5.sU().channelId;
            }
            this.ewS.Kg();
            as asVar = new as("c10795");
            bjVar3 = this.ewS.ewJ;
            as Z = asVar.Z("tid", bjVar3.getTid());
            bjVar4 = this.ewS.ewJ;
            TiebaStatic.log(Z.g("fid", bjVar4.getFid()).g("obj_id", j));
        }
    }
}
