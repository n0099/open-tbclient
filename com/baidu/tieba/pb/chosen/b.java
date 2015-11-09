package com.baidu.tieba.pb.chosen;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.i;
import com.baidu.tieba.pb.chosen.a.e;
/* loaded from: classes.dex */
class b implements e.b {
    final /* synthetic */ PbChosenActivity cfM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(PbChosenActivity pbChosenActivity) {
        this.cfM = pbChosenActivity;
    }

    @Override // com.baidu.tieba.pb.chosen.a.e.b
    public void aU(String str, String str2) {
        this.cfM.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.cfM.getPageContext().getPageActivity(), str, str2)));
    }

    @Override // com.baidu.tieba.pb.chosen.a.e.b
    public void jD(String str) {
        com.baidu.tieba.pb.chosen.net.a aVar;
        com.baidu.tieba.pb.chosen.net.a aVar2;
        com.baidu.tieba.pb.chosen.net.a aVar3;
        com.baidu.tieba.pb.chosen.net.a aVar4;
        if (!StringUtils.isNull(str)) {
            this.cfM.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.cfM.getPageContext().getPageActivity()).createNormalCfg(str, "from_chosen_pb")));
            aVar = this.cfM.chosenData;
            if (aVar != null) {
                aVar2 = this.cfM.chosenData;
                if (aVar2.getForumInfo() != null) {
                    aVar3 = this.cfM.chosenData;
                    if (aVar3.getForumInfo().ftid != null) {
                        Activity pageActivity = this.cfM.getPageContext().getPageActivity();
                        aVar4 = this.cfM.chosenData;
                        TiebaStatic.eventStat(pageActivity, "pb_new_sourcefid", null, 1, PbChosenActivityConfig.KEY_TID, aVar4.getForumInfo().ftid);
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.pb.chosen.a.e.b
    public void aeV() {
        com.baidu.tieba.pb.chosen.net.a aVar;
        com.baidu.tieba.pb.chosen.net.a aVar2;
        com.baidu.tieba.pb.chosen.net.a aVar3;
        com.baidu.tieba.tbadkCore.w wVar;
        com.baidu.tieba.tbadkCore.w wVar2;
        com.baidu.tieba.tbadkCore.w wVar3;
        com.baidu.tieba.tbadkCore.w wVar4;
        com.baidu.tieba.pb.chosen.net.a aVar4;
        com.baidu.tieba.pb.chosen.net.a aVar5;
        if (!com.baidu.adp.lib.util.i.iN()) {
            BdToast.b(this.cfM.getPageContext().getPageActivity(), this.cfM.getResources().getString(i.h.neterror)).sZ();
        } else if (this.cfM.checkUpIsLogin()) {
            aVar = this.cfM.chosenData;
            if (aVar != null) {
                aVar2 = this.cfM.chosenData;
                if (aVar2.getForumInfo() != null) {
                    aVar3 = this.cfM.chosenData;
                    if (aVar3.getForumInfo().fromfid != null) {
                        wVar = this.cfM.cfx;
                        if (wVar == null) {
                            this.cfM.cfx = new com.baidu.tieba.tbadkCore.w(this.cfM.getPageContext());
                        }
                        wVar2 = this.cfM.cfx;
                        wVar2.setFrom("from_frs");
                        wVar3 = this.cfM.cfx;
                        wVar3.setLoadDataCallBack(new c(this));
                        wVar4 = this.cfM.cfx;
                        aVar4 = this.cfM.chosenData;
                        String str = aVar4.getForumInfo().fromfname;
                        aVar5 = this.cfM.chosenData;
                        wVar4.bd(str, String.valueOf(aVar5.getForumInfo().fromfid));
                        TiebaStatic.log("c10322");
                    }
                }
            }
        }
    }
}
