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
    final /* synthetic */ d exo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(d dVar) {
        this.exo = dVar;
    }

    @Override // com.baidu.tieba.play.c.d
    public void aQy() {
        PbActivity pbActivity;
        bi biVar;
        bi biVar2;
        PbActivity pbActivity2;
        bi biVar3;
        bi biVar4;
        bi biVar5;
        bi biVar6;
        pbActivity = this.exo.ekw;
        if (pbActivity != null) {
            biVar = this.exo.exg;
            if (biVar != null) {
                biVar2 = this.exo.exg;
                if (!StringUtils.isNull(biVar2.getId())) {
                    pbActivity2 = this.exo.ekw;
                    biVar3 = this.exo.exg;
                    pbActivity2.nu(biVar3.getId());
                    biVar4 = this.exo.exf;
                    if (biVar4 != null) {
                        long j = 0;
                        biVar5 = this.exo.exf;
                        if (biVar5.ts() != null) {
                            biVar6 = this.exo.exf;
                            j = biVar6.ts().channelId;
                        }
                        TiebaStatic.log(new as("c11921").g("obj_id", j));
                    }
                }
            }
        }
    }
}
