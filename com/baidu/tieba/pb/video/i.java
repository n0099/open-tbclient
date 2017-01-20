package com.baidu.tieba.pb.video;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.play.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements c.d {
    final /* synthetic */ d etA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(d dVar) {
        this.etA = dVar;
    }

    @Override // com.baidu.tieba.play.c.d
    public void aPL() {
        PbActivity pbActivity;
        bh bhVar;
        bh bhVar2;
        PbActivity pbActivity2;
        bh bhVar3;
        bh bhVar4;
        bh bhVar5;
        bh bhVar6;
        pbActivity = this.etA.ehi;
        if (pbActivity != null) {
            bhVar = this.etA.etv;
            if (bhVar != null) {
                bhVar2 = this.etA.etv;
                if (!StringUtils.isNull(bhVar2.getId())) {
                    pbActivity2 = this.etA.ehi;
                    bhVar3 = this.etA.etv;
                    pbActivity2.og(bhVar3.getId());
                    bhVar4 = this.etA.etu;
                    if (bhVar4 != null) {
                        long j = 0;
                        bhVar5 = this.etA.etu;
                        if (bhVar5.sz() != null) {
                            bhVar6 = this.etA.etu;
                            j = bhVar6.sz().channelId;
                        }
                        TiebaStatic.log(new ar("c11921").g("obj_id", j));
                    }
                }
            }
        }
    }
}
