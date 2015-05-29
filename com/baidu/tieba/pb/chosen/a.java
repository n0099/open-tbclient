package com.baidu.tieba.pb.chosen;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class a implements com.baidu.tieba.pb.chosen.a.k {
    final /* synthetic */ PbChosenActivity bJa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(PbChosenActivity pbChosenActivity) {
        this.bJa = pbChosenActivity;
    }

    @Override // com.baidu.tieba.pb.chosen.a.k
    public void c(long j, String str) {
        com.baidu.tieba.pb.chosen.net.a aVar;
        com.baidu.tieba.pb.chosen.net.a aVar2;
        com.baidu.tieba.pb.chosen.net.a aVar3;
        com.baidu.tieba.pb.chosen.net.a aVar4;
        if (!StringUtils.isNull(str)) {
            this.bJa.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.bJa.getPageContext().getPageActivity()).createNormalCfg(str, null, null)));
            aVar = this.bJa.chosenData;
            if (aVar != null) {
                aVar2 = this.bJa.chosenData;
                if (aVar2.getForumInfo() != null) {
                    aVar3 = this.bJa.chosenData;
                    if (aVar3.getForumInfo().ftid != null) {
                        Activity pageActivity = this.bJa.getPageContext().getPageActivity();
                        aVar4 = this.bJa.chosenData;
                        TiebaStatic.eventStat(pageActivity, "pb_new_detail_btn", null, 1, PbChosenActivityConfig.KEY_TID, aVar4.getForumInfo().ftid);
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.pb.chosen.a.k
    public void dM(boolean z) {
        com.baidu.tieba.pb.chosen.net.a aVar;
        com.baidu.tieba.pb.chosen.net.a aVar2;
        com.baidu.tieba.pb.chosen.net.a aVar3;
        com.baidu.tieba.pb.chosen.net.zan.a aVar4;
        com.baidu.tieba.pb.chosen.net.zan.a aVar5;
        com.baidu.tieba.pb.chosen.net.a aVar6;
        com.baidu.tieba.pb.chosen.net.a aVar7;
        com.baidu.tieba.pb.chosen.net.zan.a aVar8;
        com.baidu.tieba.pb.chosen.net.a aVar9;
        aVar = this.bJa.chosenData;
        if (aVar != null) {
            aVar2 = this.bJa.chosenData;
            if (aVar2.getForumInfo() != null) {
                aVar3 = this.bJa.chosenData;
                if (aVar3.getForumInfo().ftid != null) {
                    aVar4 = this.bJa.bIR;
                    if (aVar4 == null) {
                        this.bJa.bIR = new com.baidu.tieba.pb.chosen.net.zan.a();
                    }
                    if (z) {
                        aVar8 = this.bJa.bIR;
                        PbChosenActivity pbChosenActivity = this.bJa;
                        aVar9 = this.bJa.chosenData;
                        aVar8.a(pbChosenActivity, aVar9.getForumInfo().ftid.longValue(), "unlike");
                    } else {
                        aVar5 = this.bJa.bIR;
                        PbChosenActivity pbChosenActivity2 = this.bJa;
                        aVar6 = this.bJa.chosenData;
                        aVar5.a(pbChosenActivity2, aVar6.getForumInfo().ftid.longValue(), "like");
                    }
                    Activity pageActivity = this.bJa.getPageContext().getPageActivity();
                    aVar7 = this.bJa.chosenData;
                    TiebaStatic.eventStat(pageActivity, "pb_new_like", null, 1, PbChosenActivityConfig.KEY_TID, aVar7.getForumInfo().ftid);
                }
            }
        }
    }
}
