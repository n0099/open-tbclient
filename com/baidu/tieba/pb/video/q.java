package com.baidu.tieba.pb.video;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.play.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements c.d {
    final /* synthetic */ g esY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(g gVar) {
        this.esY = gVar;
    }

    @Override // com.baidu.tieba.play.c.d
    public void aNP() {
        PbActivity pbActivity;
        bk bkVar;
        bk bkVar2;
        PbActivity pbActivity2;
        bk bkVar3;
        bk bkVar4;
        bk bkVar5;
        bk bkVar6;
        pbActivity = this.esY.efF;
        if (pbActivity != null) {
            bkVar = this.esY.esQ;
            if (bkVar != null) {
                bkVar2 = this.esY.esQ;
                if (!StringUtils.isNull(bkVar2.getId())) {
                    pbActivity2 = this.esY.efF;
                    bkVar3 = this.esY.esQ;
                    pbActivity2.nB(bkVar3.getId());
                    bkVar4 = this.esY.esP;
                    if (bkVar4 != null) {
                        long j = 0;
                        bkVar5 = this.esY.esP;
                        if (bkVar5.sC() != null) {
                            bkVar6 = this.esY.esP;
                            j = bkVar6.sC().channelId;
                        }
                        TiebaStatic.log(new as("c11921").g("obj_id", j));
                    }
                }
            }
        }
    }
}
