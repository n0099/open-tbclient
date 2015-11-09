package com.baidu.tieba.pb.chosen;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.pb.chosen.a.d;
/* loaded from: classes.dex */
class n implements d.a {
    final /* synthetic */ PbChosenActivity cfM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(PbChosenActivity pbChosenActivity) {
        this.cfM = pbChosenActivity;
    }

    @Override // com.baidu.tieba.pb.chosen.a.d.a
    public void jE(String str) {
        com.baidu.tieba.pb.chosen.net.a aVar;
        com.baidu.tieba.pb.chosen.net.a aVar2;
        com.baidu.tieba.pb.chosen.net.a aVar3;
        if (this.cfM.checkUpIsLogin()) {
            aVar = this.cfM.chosenData;
            if (aVar != null) {
                aVar2 = this.cfM.chosenData;
                if (aVar2.getForumInfo() != null && !StringUtils.isNull(str)) {
                    TiebaStatic.log("c10093");
                    aVar3 = this.cfM.chosenData;
                    this.cfM.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(this.cfM.getPageContext().getPageActivity()).createSubPbActivityConfig(aVar3.getForumInfo().originalurl, str, "pb_chosen", true)));
                }
            }
        }
    }
}
