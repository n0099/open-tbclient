package com.baidu.tieba.pb.chosen;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.pb.chosen.a.d;
/* loaded from: classes.dex */
class m implements d.a {
    final /* synthetic */ PbChosenActivity bZS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(PbChosenActivity pbChosenActivity) {
        this.bZS = pbChosenActivity;
    }

    @Override // com.baidu.tieba.pb.chosen.a.d.a
    public void jk(String str) {
        com.baidu.tieba.pb.chosen.net.a aVar;
        com.baidu.tieba.pb.chosen.net.a aVar2;
        com.baidu.tieba.pb.chosen.net.a aVar3;
        if (this.bZS.checkUpIsLogin()) {
            aVar = this.bZS.chosenData;
            if (aVar != null) {
                aVar2 = this.bZS.chosenData;
                if (aVar2.getForumInfo() != null && !StringUtils.isNull(str)) {
                    TiebaStatic.log("c10093");
                    aVar3 = this.bZS.chosenData;
                    this.bZS.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(this.bZS.getPageContext().getPageActivity()).createSubPbActivityConfig(aVar3.getForumInfo().originalurl, str, "pb_chosen", true)));
                }
            }
        }
    }
}
