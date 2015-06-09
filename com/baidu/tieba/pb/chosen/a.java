package com.baidu.tieba.pb.chosen;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class a implements com.baidu.tieba.pb.chosen.a.k {
    final /* synthetic */ PbChosenActivity bJb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(PbChosenActivity pbChosenActivity) {
        this.bJb = pbChosenActivity;
    }

    @Override // com.baidu.tieba.pb.chosen.a.k
    public void c(long j, String str) {
        com.baidu.tieba.pb.chosen.net.a aVar;
        com.baidu.tieba.pb.chosen.net.a aVar2;
        com.baidu.tieba.pb.chosen.net.a aVar3;
        com.baidu.tieba.pb.chosen.net.a aVar4;
        if (!StringUtils.isNull(str)) {
            this.bJb.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.bJb.getPageContext().getPageActivity()).createNormalCfg(str, null, null)));
            aVar = this.bJb.chosenData;
            if (aVar != null) {
                aVar2 = this.bJb.chosenData;
                if (aVar2.getForumInfo() != null) {
                    aVar3 = this.bJb.chosenData;
                    if (aVar3.getForumInfo().ftid != null) {
                        Activity pageActivity = this.bJb.getPageContext().getPageActivity();
                        aVar4 = this.bJb.chosenData;
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
        aVar = this.bJb.chosenData;
        if (aVar != null) {
            aVar2 = this.bJb.chosenData;
            if (aVar2.getForumInfo() != null) {
                aVar3 = this.bJb.chosenData;
                if (aVar3.getForumInfo().ftid != null) {
                    aVar4 = this.bJb.bIS;
                    if (aVar4 == null) {
                        this.bJb.bIS = new com.baidu.tieba.pb.chosen.net.zan.a();
                    }
                    if (z) {
                        aVar8 = this.bJb.bIS;
                        PbChosenActivity pbChosenActivity = this.bJb;
                        aVar9 = this.bJb.chosenData;
                        aVar8.a(pbChosenActivity, aVar9.getForumInfo().ftid.longValue(), "unlike");
                    } else {
                        aVar5 = this.bJb.bIS;
                        PbChosenActivity pbChosenActivity2 = this.bJb;
                        aVar6 = this.bJb.chosenData;
                        aVar5.a(pbChosenActivity2, aVar6.getForumInfo().ftid.longValue(), "like");
                    }
                    Activity pageActivity = this.bJb.getPageContext().getPageActivity();
                    aVar7 = this.bJb.chosenData;
                    TiebaStatic.eventStat(pageActivity, "pb_new_like", null, 1, PbChosenActivityConfig.KEY_TID, aVar7.getForumInfo().ftid);
                }
            }
        }
    }
}
