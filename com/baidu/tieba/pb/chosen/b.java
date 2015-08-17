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
    final /* synthetic */ PbChosenActivity bYY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(PbChosenActivity pbChosenActivity) {
        this.bYY = pbChosenActivity;
    }

    @Override // com.baidu.tieba.pb.chosen.a.e.b
    public void aT(String str, String str2) {
        this.bYY.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.bYY.getPageContext().getPageActivity(), str, str2)));
    }

    @Override // com.baidu.tieba.pb.chosen.a.e.b
    public void jb(String str) {
        com.baidu.tieba.pb.chosen.net.a aVar;
        com.baidu.tieba.pb.chosen.net.a aVar2;
        com.baidu.tieba.pb.chosen.net.a aVar3;
        com.baidu.tieba.pb.chosen.net.a aVar4;
        if (!StringUtils.isNull(str)) {
            this.bYY.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.bYY.getPageContext().getPageActivity()).createNormalCfg(str, "from_chosen_pb")));
            aVar = this.bYY.chosenData;
            if (aVar != null) {
                aVar2 = this.bYY.chosenData;
                if (aVar2.getForumInfo() != null) {
                    aVar3 = this.bYY.chosenData;
                    if (aVar3.getForumInfo().ftid != null) {
                        Activity pageActivity = this.bYY.getPageContext().getPageActivity();
                        aVar4 = this.bYY.chosenData;
                        TiebaStatic.eventStat(pageActivity, "pb_new_sourcefid", null, 1, PbChosenActivityConfig.KEY_TID, aVar4.getForumInfo().ftid);
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.pb.chosen.a.e.b
    public void acy() {
        com.baidu.tieba.pb.chosen.net.a aVar;
        com.baidu.tieba.pb.chosen.net.a aVar2;
        com.baidu.tieba.pb.chosen.net.a aVar3;
        com.baidu.tieba.tbadkCore.v vVar;
        com.baidu.tieba.tbadkCore.v vVar2;
        com.baidu.tieba.tbadkCore.v vVar3;
        com.baidu.tieba.pb.chosen.net.a aVar4;
        com.baidu.tieba.pb.chosen.net.a aVar5;
        if (!com.baidu.adp.lib.util.i.iO()) {
            BdToast.b(this.bYY.getPageContext().getPageActivity(), this.bYY.getResources().getString(i.C0057i.neterror)).sX();
        } else if (this.bYY.checkUpIsLogin()) {
            aVar = this.bYY.chosenData;
            if (aVar != null) {
                aVar2 = this.bYY.chosenData;
                if (aVar2.getForumInfo() != null) {
                    aVar3 = this.bYY.chosenData;
                    if (aVar3.getForumInfo().fromfid != null) {
                        vVar = this.bYY.bYJ;
                        if (vVar == null) {
                            this.bYY.bYJ = new com.baidu.tieba.tbadkCore.v(this.bYY.getPageContext());
                        }
                        vVar2 = this.bYY.bYJ;
                        vVar2.setFrom("from_frs");
                        vVar3 = this.bYY.bYJ;
                        aVar4 = this.bYY.chosenData;
                        String str = aVar4.getForumInfo().fromfname;
                        aVar5 = this.bYY.chosenData;
                        vVar3.ba(str, String.valueOf(aVar5.getForumInfo().fromfid));
                    }
                }
            }
        }
    }
}
