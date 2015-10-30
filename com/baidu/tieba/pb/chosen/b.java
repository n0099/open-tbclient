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
    final /* synthetic */ PbChosenActivity cfl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(PbChosenActivity pbChosenActivity) {
        this.cfl = pbChosenActivity;
    }

    @Override // com.baidu.tieba.pb.chosen.a.e.b
    public void aV(String str, String str2) {
        this.cfl.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.cfl.getPageContext().getPageActivity(), str, str2)));
    }

    @Override // com.baidu.tieba.pb.chosen.a.e.b
    public void jB(String str) {
        com.baidu.tieba.pb.chosen.net.a aVar;
        com.baidu.tieba.pb.chosen.net.a aVar2;
        com.baidu.tieba.pb.chosen.net.a aVar3;
        com.baidu.tieba.pb.chosen.net.a aVar4;
        if (!StringUtils.isNull(str)) {
            this.cfl.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.cfl.getPageContext().getPageActivity()).createNormalCfg(str, "from_chosen_pb")));
            aVar = this.cfl.chosenData;
            if (aVar != null) {
                aVar2 = this.cfl.chosenData;
                if (aVar2.getForumInfo() != null) {
                    aVar3 = this.cfl.chosenData;
                    if (aVar3.getForumInfo().ftid != null) {
                        Activity pageActivity = this.cfl.getPageContext().getPageActivity();
                        aVar4 = this.cfl.chosenData;
                        TiebaStatic.eventStat(pageActivity, "pb_new_sourcefid", null, 1, PbChosenActivityConfig.KEY_TID, aVar4.getForumInfo().ftid);
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.pb.chosen.a.e.b
    public void aeA() {
        com.baidu.tieba.pb.chosen.net.a aVar;
        com.baidu.tieba.pb.chosen.net.a aVar2;
        com.baidu.tieba.pb.chosen.net.a aVar3;
        com.baidu.tieba.tbadkCore.w wVar;
        com.baidu.tieba.tbadkCore.w wVar2;
        com.baidu.tieba.tbadkCore.w wVar3;
        com.baidu.tieba.tbadkCore.w wVar4;
        com.baidu.tieba.pb.chosen.net.a aVar4;
        com.baidu.tieba.pb.chosen.net.a aVar5;
        if (!com.baidu.adp.lib.util.i.iM()) {
            BdToast.b(this.cfl.getPageContext().getPageActivity(), this.cfl.getResources().getString(i.h.neterror)).sW();
        } else if (this.cfl.checkUpIsLogin()) {
            aVar = this.cfl.chosenData;
            if (aVar != null) {
                aVar2 = this.cfl.chosenData;
                if (aVar2.getForumInfo() != null) {
                    aVar3 = this.cfl.chosenData;
                    if (aVar3.getForumInfo().fromfid != null) {
                        wVar = this.cfl.ceW;
                        if (wVar == null) {
                            this.cfl.ceW = new com.baidu.tieba.tbadkCore.w(this.cfl.getPageContext());
                        }
                        wVar2 = this.cfl.ceW;
                        wVar2.setFrom("from_frs");
                        wVar3 = this.cfl.ceW;
                        wVar3.setLoadDataCallBack(new c(this));
                        wVar4 = this.cfl.ceW;
                        aVar4 = this.cfl.chosenData;
                        String str = aVar4.getForumInfo().fromfname;
                        aVar5 = this.cfl.chosenData;
                        wVar4.be(str, String.valueOf(aVar5.getForumInfo().fromfid));
                        TiebaStatic.log("c10322");
                    }
                }
            }
        }
    }
}
