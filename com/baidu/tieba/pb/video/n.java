package com.baidu.tieba.pb.video;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.play.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements c.d {
    final /* synthetic */ d euY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(d dVar) {
        this.euY = dVar;
    }

    @Override // com.baidu.tieba.play.c.d
    public void aPx() {
        PbActivity pbActivity;
        bi biVar;
        bi biVar2;
        PbActivity pbActivity2;
        bi biVar3;
        bi biVar4;
        bi biVar5;
        bi biVar6;
        pbActivity = this.euY.eig;
        if (pbActivity != null) {
            biVar = this.euY.euQ;
            if (biVar != null) {
                biVar2 = this.euY.euQ;
                if (!StringUtils.isNull(biVar2.getId())) {
                    pbActivity2 = this.euY.eig;
                    biVar3 = this.euY.euQ;
                    pbActivity2.nt(biVar3.getId());
                    biVar4 = this.euY.euP;
                    if (biVar4 != null) {
                        long j = 0;
                        biVar5 = this.euY.euP;
                        if (biVar5.ts() != null) {
                            biVar6 = this.euY.euP;
                            j = biVar6.ts().channelId;
                        }
                        TiebaStatic.log(new as("c11921").g("obj_id", j));
                    }
                }
            }
        }
    }
}
