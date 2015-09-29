package com.baidu.tieba.pb.chosen;

import android.app.Activity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.pb.chosen.a.i;
/* loaded from: classes.dex */
class r implements i.a {
    final /* synthetic */ PbChosenActivity cfa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(PbChosenActivity pbChosenActivity) {
        this.cfa = pbChosenActivity;
    }

    @Override // com.baidu.tieba.pb.chosen.a.i.a
    public void e(long j, String str) {
        com.baidu.tieba.pb.chosen.net.a aVar;
        com.baidu.tieba.pb.chosen.net.a aVar2;
        com.baidu.tieba.pb.chosen.net.a aVar3;
        com.baidu.tieba.pb.chosen.net.a aVar4;
        if (!StringUtils.isNull(str)) {
            this.cfa.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.cfa.getPageContext().getPageActivity()).createNormalCfg(str, null, null)));
            aVar = this.cfa.chosenData;
            if (aVar != null) {
                aVar2 = this.cfa.chosenData;
                if (aVar2.getForumInfo() != null) {
                    aVar3 = this.cfa.chosenData;
                    if (aVar3.getForumInfo().ftid != null) {
                        Activity pageActivity = this.cfa.getPageContext().getPageActivity();
                        aVar4 = this.cfa.chosenData;
                        TiebaStatic.eventStat(pageActivity, "pb_new_detail_btn", null, 1, PbChosenActivityConfig.KEY_TID, aVar4.getForumInfo().ftid);
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.pb.chosen.a.i.a
    public void ej(boolean z) {
        com.baidu.tieba.pb.chosen.net.a aVar;
        com.baidu.tieba.pb.chosen.net.a aVar2;
        com.baidu.tieba.pb.chosen.net.a aVar3;
        com.baidu.tieba.pb.chosen.net.zan.a aVar4;
        com.baidu.tieba.pb.chosen.net.zan.a aVar5;
        com.baidu.tieba.pb.chosen.net.a aVar6;
        com.baidu.tieba.pb.chosen.net.a aVar7;
        com.baidu.tieba.pb.chosen.net.zan.a aVar8;
        com.baidu.tieba.pb.chosen.net.a aVar9;
        aVar = this.cfa.chosenData;
        if (aVar != null) {
            aVar2 = this.cfa.chosenData;
            if (aVar2.getForumInfo() != null) {
                aVar3 = this.cfa.chosenData;
                if (aVar3.getForumInfo().ftid != null) {
                    aVar4 = this.cfa.ceM;
                    if (aVar4 == null) {
                        this.cfa.ceM = new com.baidu.tieba.pb.chosen.net.zan.a();
                    }
                    if (z) {
                        aVar8 = this.cfa.ceM;
                        PbChosenActivity pbChosenActivity = this.cfa;
                        aVar9 = this.cfa.chosenData;
                        aVar8.a(pbChosenActivity, aVar9.getForumInfo().ftid.longValue(), "unlike");
                    } else {
                        aVar5 = this.cfa.ceM;
                        PbChosenActivity pbChosenActivity2 = this.cfa;
                        aVar6 = this.cfa.chosenData;
                        aVar5.a(pbChosenActivity2, aVar6.getForumInfo().ftid.longValue(), "like");
                    }
                    Activity pageActivity = this.cfa.getPageContext().getPageActivity();
                    aVar7 = this.cfa.chosenData;
                    TiebaStatic.eventStat(pageActivity, "pb_new_like", null, 1, PbChosenActivityConfig.KEY_TID, aVar7.getForumInfo().ftid);
                }
            }
        }
    }

    @Override // com.baidu.tieba.pb.chosen.a.i.a
    public void jD(String str) {
        com.baidu.tieba.pb.chosen.net.a aVar;
        Activity pageActivity = this.cfa.getPageContext().getPageActivity();
        aVar = this.cfa.chosenData;
        TiebaStatic.eventStat(pageActivity, "kantie_2", null, 1, PbChosenActivityConfig.KEY_TID, aVar.getForumInfo().ftid);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEMD_FRS_SWITCH_TAB, str));
        this.cfa.finish();
    }
}
