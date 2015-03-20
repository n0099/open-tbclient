package com.baidu.tieba.pb.chosen;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class g implements com.baidu.tieba.pb.chosen.a.i {
    final /* synthetic */ PbChosenActivity bFY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PbChosenActivity pbChosenActivity) {
        this.bFY = pbChosenActivity;
    }

    @Override // com.baidu.tieba.pb.chosen.a.i
    public void b(long j, String str) {
        if (!StringUtils.isNull(str)) {
            this.bFY.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.bFY.getPageContext().getPageActivity()).createNormalCfg(str, null, null)));
            TiebaStatic.eventStat(this.bFY.getPageContext().getPageActivity(), "pb_new_detail_btn", null);
        }
    }

    @Override // com.baidu.tieba.pb.chosen.a.i
    public void hy(String str) {
        if (!StringUtils.isNull(str)) {
            this.bFY.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.bFY.getPageContext().getPageActivity()).createNormalCfg(str, "from_chosen_pb")));
            TiebaStatic.eventStat(this.bFY.getPageContext().getPageActivity(), "pb_new_sourcefid", null);
        }
    }

    @Override // com.baidu.tieba.pb.chosen.a.i
    public void dC(boolean z) {
        com.baidu.tieba.pb.chosen.net.a aVar;
        com.baidu.tieba.pb.chosen.net.a aVar2;
        com.baidu.tieba.pb.chosen.net.zan.a aVar3;
        com.baidu.tieba.pb.chosen.net.zan.a aVar4;
        com.baidu.tieba.pb.chosen.net.a aVar5;
        com.baidu.tieba.pb.chosen.net.zan.a aVar6;
        com.baidu.tieba.pb.chosen.net.a aVar7;
        aVar = this.bFY.chosenData;
        if (aVar != null) {
            aVar2 = this.bFY.chosenData;
            if (aVar2.getForumInfo() != null) {
                aVar3 = this.bFY.bFP;
                if (aVar3 == null) {
                    this.bFY.bFP = new com.baidu.tieba.pb.chosen.net.zan.a();
                }
                if (z) {
                    aVar6 = this.bFY.bFP;
                    PbChosenActivity pbChosenActivity = this.bFY;
                    aVar7 = this.bFY.chosenData;
                    aVar6.a(pbChosenActivity, aVar7.getForumInfo().ftid.longValue(), "unlike");
                } else {
                    aVar4 = this.bFY.bFP;
                    PbChosenActivity pbChosenActivity2 = this.bFY;
                    aVar5 = this.bFY.chosenData;
                    aVar4.a(pbChosenActivity2, aVar5.getForumInfo().ftid.longValue(), "like");
                }
                TiebaStatic.eventStat(this.bFY.getPageContext().getPageActivity(), "pb_new_like", null);
            }
        }
    }
}
