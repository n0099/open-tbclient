package com.baidu.tieba.pb.chosen;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class g implements com.baidu.tieba.pb.chosen.a.i {
    final /* synthetic */ PbChosenActivity bGl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PbChosenActivity pbChosenActivity) {
        this.bGl = pbChosenActivity;
    }

    @Override // com.baidu.tieba.pb.chosen.a.i
    public void b(long j, String str) {
        if (!StringUtils.isNull(str)) {
            this.bGl.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.bGl.getPageContext().getPageActivity()).createNormalCfg(str, null, null)));
            TiebaStatic.eventStat(this.bGl.getPageContext().getPageActivity(), "pb_new_detail_btn", null);
        }
    }

    @Override // com.baidu.tieba.pb.chosen.a.i
    public void hB(String str) {
        if (!StringUtils.isNull(str)) {
            this.bGl.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.bGl.getPageContext().getPageActivity()).createNormalCfg(str, "from_chosen_pb")));
            TiebaStatic.eventStat(this.bGl.getPageContext().getPageActivity(), "pb_new_sourcefid", null);
        }
    }

    @Override // com.baidu.tieba.pb.chosen.a.i
    public void dA(boolean z) {
        com.baidu.tieba.pb.chosen.net.a aVar;
        com.baidu.tieba.pb.chosen.net.a aVar2;
        com.baidu.tieba.pb.chosen.net.zan.a aVar3;
        com.baidu.tieba.pb.chosen.net.zan.a aVar4;
        com.baidu.tieba.pb.chosen.net.a aVar5;
        com.baidu.tieba.pb.chosen.net.zan.a aVar6;
        com.baidu.tieba.pb.chosen.net.a aVar7;
        aVar = this.bGl.chosenData;
        if (aVar != null) {
            aVar2 = this.bGl.chosenData;
            if (aVar2.getForumInfo() != null) {
                aVar3 = this.bGl.bGc;
                if (aVar3 == null) {
                    this.bGl.bGc = new com.baidu.tieba.pb.chosen.net.zan.a();
                }
                if (z) {
                    aVar6 = this.bGl.bGc;
                    PbChosenActivity pbChosenActivity = this.bGl;
                    aVar7 = this.bGl.chosenData;
                    aVar6.a(pbChosenActivity, aVar7.getForumInfo().ftid.longValue(), "unlike");
                } else {
                    aVar4 = this.bGl.bGc;
                    PbChosenActivity pbChosenActivity2 = this.bGl;
                    aVar5 = this.bGl.chosenData;
                    aVar4.a(pbChosenActivity2, aVar5.getForumInfo().ftid.longValue(), "like");
                }
                TiebaStatic.eventStat(this.bGl.getPageContext().getPageActivity(), "pb_new_like", null);
            }
        }
    }
}
