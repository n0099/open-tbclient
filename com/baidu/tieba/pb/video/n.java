package com.baidu.tieba.pb.video;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.play.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements c.d {
    final /* synthetic */ d ewS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(d dVar) {
        this.ewS = dVar;
    }

    @Override // com.baidu.tieba.play.c.d
    public void aPo() {
        PbActivity pbActivity;
        bj bjVar;
        bj bjVar2;
        PbActivity pbActivity2;
        bj bjVar3;
        bj bjVar4;
        bj bjVar5;
        bj bjVar6;
        pbActivity = this.ewS.eka;
        if (pbActivity != null) {
            bjVar = this.ewS.ewK;
            if (bjVar != null) {
                bjVar2 = this.ewS.ewK;
                if (!StringUtils.isNull(bjVar2.getId())) {
                    pbActivity2 = this.ewS.eka;
                    bjVar3 = this.ewS.ewK;
                    pbActivity2.nn(bjVar3.getId());
                    bjVar4 = this.ewS.ewJ;
                    if (bjVar4 != null) {
                        long j = 0;
                        bjVar5 = this.ewS.ewJ;
                        if (bjVar5.sU() != null) {
                            bjVar6 = this.ewS.ewJ;
                            j = bjVar6.sU().channelId;
                        }
                        TiebaStatic.log(new as("c11921").g("obj_id", j));
                    }
                }
            }
        }
    }
}
