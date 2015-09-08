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
    final /* synthetic */ PbChosenActivity bZS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(PbChosenActivity pbChosenActivity) {
        this.bZS = pbChosenActivity;
    }

    @Override // com.baidu.tieba.pb.chosen.a.e.b
    public void aV(String str, String str2) {
        this.bZS.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.bZS.getPageContext().getPageActivity(), str, str2)));
    }

    @Override // com.baidu.tieba.pb.chosen.a.e.b
    public void jj(String str) {
        com.baidu.tieba.pb.chosen.net.a aVar;
        com.baidu.tieba.pb.chosen.net.a aVar2;
        com.baidu.tieba.pb.chosen.net.a aVar3;
        com.baidu.tieba.pb.chosen.net.a aVar4;
        if (!StringUtils.isNull(str)) {
            this.bZS.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.bZS.getPageContext().getPageActivity()).createNormalCfg(str, "from_chosen_pb")));
            aVar = this.bZS.chosenData;
            if (aVar != null) {
                aVar2 = this.bZS.chosenData;
                if (aVar2.getForumInfo() != null) {
                    aVar3 = this.bZS.chosenData;
                    if (aVar3.getForumInfo().ftid != null) {
                        Activity pageActivity = this.bZS.getPageContext().getPageActivity();
                        aVar4 = this.bZS.chosenData;
                        TiebaStatic.eventStat(pageActivity, "pb_new_sourcefid", null, 1, PbChosenActivityConfig.KEY_TID, aVar4.getForumInfo().ftid);
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.pb.chosen.a.e.b
    public void acH() {
        com.baidu.tieba.pb.chosen.net.a aVar;
        com.baidu.tieba.pb.chosen.net.a aVar2;
        com.baidu.tieba.pb.chosen.net.a aVar3;
        com.baidu.tieba.tbadkCore.w wVar;
        com.baidu.tieba.tbadkCore.w wVar2;
        com.baidu.tieba.tbadkCore.w wVar3;
        com.baidu.tieba.pb.chosen.net.a aVar4;
        com.baidu.tieba.pb.chosen.net.a aVar5;
        if (!com.baidu.adp.lib.util.i.iL()) {
            BdToast.b(this.bZS.getPageContext().getPageActivity(), this.bZS.getResources().getString(i.h.neterror)).tc();
        } else if (this.bZS.checkUpIsLogin()) {
            aVar = this.bZS.chosenData;
            if (aVar != null) {
                aVar2 = this.bZS.chosenData;
                if (aVar2.getForumInfo() != null) {
                    aVar3 = this.bZS.chosenData;
                    if (aVar3.getForumInfo().fromfid != null) {
                        wVar = this.bZS.bZD;
                        if (wVar == null) {
                            this.bZS.bZD = new com.baidu.tieba.tbadkCore.w(this.bZS.getPageContext());
                        }
                        wVar2 = this.bZS.bZD;
                        wVar2.setFrom("from_frs");
                        wVar3 = this.bZS.bZD;
                        aVar4 = this.bZS.chosenData;
                        String str = aVar4.getForumInfo().fromfname;
                        aVar5 = this.bZS.chosenData;
                        wVar3.be(str, String.valueOf(aVar5.getForumInfo().fromfid));
                        TiebaStatic.log("c10322");
                    }
                }
            }
        }
    }
}
