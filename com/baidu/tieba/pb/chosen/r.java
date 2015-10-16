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
    final /* synthetic */ PbChosenActivity cfl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(PbChosenActivity pbChosenActivity) {
        this.cfl = pbChosenActivity;
    }

    @Override // com.baidu.tieba.pb.chosen.a.i.a
    public void e(long j, String str) {
        com.baidu.tieba.pb.chosen.net.a aVar;
        com.baidu.tieba.pb.chosen.net.a aVar2;
        com.baidu.tieba.pb.chosen.net.a aVar3;
        com.baidu.tieba.pb.chosen.net.a aVar4;
        if (!StringUtils.isNull(str)) {
            this.cfl.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.cfl.getPageContext().getPageActivity()).createNormalCfg(str, null, null)));
            aVar = this.cfl.chosenData;
            if (aVar != null) {
                aVar2 = this.cfl.chosenData;
                if (aVar2.getForumInfo() != null) {
                    aVar3 = this.cfl.chosenData;
                    if (aVar3.getForumInfo().ftid != null) {
                        Activity pageActivity = this.cfl.getPageContext().getPageActivity();
                        aVar4 = this.cfl.chosenData;
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
        aVar = this.cfl.chosenData;
        if (aVar != null) {
            aVar2 = this.cfl.chosenData;
            if (aVar2.getForumInfo() != null) {
                aVar3 = this.cfl.chosenData;
                if (aVar3.getForumInfo().ftid != null) {
                    aVar4 = this.cfl.ceX;
                    if (aVar4 == null) {
                        this.cfl.ceX = new com.baidu.tieba.pb.chosen.net.zan.a();
                    }
                    if (z) {
                        aVar8 = this.cfl.ceX;
                        PbChosenActivity pbChosenActivity = this.cfl;
                        aVar9 = this.cfl.chosenData;
                        aVar8.a(pbChosenActivity, aVar9.getForumInfo().ftid.longValue(), "unlike");
                    } else {
                        aVar5 = this.cfl.ceX;
                        PbChosenActivity pbChosenActivity2 = this.cfl;
                        aVar6 = this.cfl.chosenData;
                        aVar5.a(pbChosenActivity2, aVar6.getForumInfo().ftid.longValue(), "like");
                    }
                    Activity pageActivity = this.cfl.getPageContext().getPageActivity();
                    aVar7 = this.cfl.chosenData;
                    TiebaStatic.eventStat(pageActivity, "pb_new_like", null, 1, PbChosenActivityConfig.KEY_TID, aVar7.getForumInfo().ftid);
                }
            }
        }
    }

    @Override // com.baidu.tieba.pb.chosen.a.i.a
    public void jD(String str) {
        com.baidu.tieba.pb.chosen.net.a aVar;
        Activity pageActivity = this.cfl.getPageContext().getPageActivity();
        aVar = this.cfl.chosenData;
        TiebaStatic.eventStat(pageActivity, "kantie_2", null, 1, PbChosenActivityConfig.KEY_TID, aVar.getForumInfo().ftid);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEMD_FRS_SWITCH_TAB, str));
        this.cfl.finish();
    }
}
