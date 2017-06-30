package com.baidu.tieba.pb.video;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.play.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements c.d {
    final /* synthetic */ l eKu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(l lVar) {
        this.eKu = lVar;
    }

    @Override // com.baidu.tieba.play.c.d
    public void aTc() {
        PbActivity pbActivity;
        bm bmVar;
        bm bmVar2;
        PbActivity pbActivity2;
        bm bmVar3;
        bm bmVar4;
        bm bmVar5;
        bm bmVar6;
        pbActivity = this.eKu.euf;
        if (pbActivity != null) {
            bmVar = this.eKu.eKa;
            if (bmVar != null) {
                bmVar2 = this.eKu.eKa;
                if (!StringUtils.isNull(bmVar2.getId())) {
                    pbActivity2 = this.eKu.euf;
                    bmVar3 = this.eKu.eKa;
                    pbActivity2.oH(bmVar3.getId());
                    bmVar4 = this.eKu.eJZ;
                    if (bmVar4 != null) {
                        long j = 0;
                        bmVar5 = this.eKu.eJZ;
                        if (bmVar5.sv() != null) {
                            bmVar6 = this.eKu.eJZ;
                            j = bmVar6.sv().channelId;
                        }
                        TiebaStatic.log(new au("c11921").f("obj_id", j));
                    }
                }
            }
        }
    }
}
