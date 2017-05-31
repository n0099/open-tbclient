package com.baidu.tieba.pb.video;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.play.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements c.d {
    final /* synthetic */ l eAW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(l lVar) {
        this.eAW = lVar;
    }

    @Override // com.baidu.tieba.play.c.d
    public void aPd() {
        PbActivity pbActivity;
        bl blVar;
        bl blVar2;
        PbActivity pbActivity2;
        bl blVar3;
        bl blVar4;
        bl blVar5;
        bl blVar6;
        pbActivity = this.eAW.elf;
        if (pbActivity != null) {
            blVar = this.eAW.eAC;
            if (blVar != null) {
                blVar2 = this.eAW.eAC;
                if (!StringUtils.isNull(blVar2.getId())) {
                    pbActivity2 = this.eAW.elf;
                    blVar3 = this.eAW.eAC;
                    pbActivity2.nN(blVar3.getId());
                    blVar4 = this.eAW.eAB;
                    if (blVar4 != null) {
                        long j = 0;
                        blVar5 = this.eAW.eAB;
                        if (blVar5.sx() != null) {
                            blVar6 = this.eAW.eAB;
                            j = blVar6.sx().channelId;
                        }
                        TiebaStatic.log(new as("c11921").f("obj_id", j));
                    }
                }
            }
        }
    }
}
