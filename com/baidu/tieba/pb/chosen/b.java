package com.baidu.tieba.pb.chosen;

import android.app.Activity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class b implements com.baidu.tieba.pb.chosen.a.g {
    final /* synthetic */ PbChosenActivity bJa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(PbChosenActivity pbChosenActivity) {
        this.bJa = pbChosenActivity;
    }

    @Override // com.baidu.tieba.pb.chosen.a.g
    public void aU(String str, String str2) {
        this.bJa.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.bJa.getPageContext().getPageActivity(), str, str2)));
    }

    @Override // com.baidu.tieba.pb.chosen.a.g
    public void ig(String str) {
        com.baidu.tieba.pb.chosen.net.a aVar;
        com.baidu.tieba.pb.chosen.net.a aVar2;
        com.baidu.tieba.pb.chosen.net.a aVar3;
        com.baidu.tieba.pb.chosen.net.a aVar4;
        if (!StringUtils.isNull(str)) {
            this.bJa.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.bJa.getPageContext().getPageActivity()).createNormalCfg(str, "from_chosen_pb")));
            aVar = this.bJa.chosenData;
            if (aVar != null) {
                aVar2 = this.bJa.chosenData;
                if (aVar2.getForumInfo() != null) {
                    aVar3 = this.bJa.chosenData;
                    if (aVar3.getForumInfo().ftid != null) {
                        Activity pageActivity = this.bJa.getPageContext().getPageActivity();
                        aVar4 = this.bJa.chosenData;
                        TiebaStatic.eventStat(pageActivity, "pb_new_sourcefid", null, 1, PbChosenActivityConfig.KEY_TID, aVar4.getForumInfo().ftid);
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.pb.chosen.a.g
    public void ih(String str) {
        com.baidu.tieba.pb.chosen.net.a aVar;
        Activity pageActivity = this.bJa.getPageContext().getPageActivity();
        aVar = this.bJa.chosenData;
        TiebaStatic.eventStat(pageActivity, "kantie_2", null, 1, PbChosenActivityConfig.KEY_TID, aVar.getForumInfo().ftid);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001328, str));
        this.bJa.finish();
    }
}
