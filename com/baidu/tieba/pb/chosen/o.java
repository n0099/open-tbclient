package com.baidu.tieba.pb.chosen;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.pb.chosen.a.d;
/* loaded from: classes.dex */
class o implements d.a {
    final /* synthetic */ PbChosenActivity cIA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(PbChosenActivity pbChosenActivity) {
        this.cIA = pbChosenActivity;
    }

    @Override // com.baidu.tieba.pb.chosen.a.d.a
    public void ku(String str) {
        com.baidu.tieba.pb.chosen.net.a aVar;
        com.baidu.tieba.pb.chosen.net.a aVar2;
        com.baidu.tieba.pb.chosen.net.a aVar3;
        com.baidu.tieba.pb.chosen.net.a aVar4;
        com.baidu.tieba.pb.chosen.net.a aVar5;
        com.baidu.tieba.pb.chosen.net.a aVar6;
        com.baidu.tieba.pb.chosen.net.a aVar7;
        com.baidu.tieba.pb.chosen.net.a aVar8;
        com.baidu.tieba.pb.chosen.net.a aVar9;
        if (this.cIA.checkUpIsLogin()) {
            aVar = this.cIA.chosenData;
            if (aVar != null) {
                aVar2 = this.cIA.chosenData;
                if (aVar2.getThreadInfo() != null && !StringUtils.isNull(str)) {
                    aVar3 = this.cIA.chosenData;
                    if (aVar3 != null) {
                        aVar5 = this.cIA.chosenData;
                        if (aVar5.getThreadInfo() != null) {
                            au auVar = new au("c10093");
                            StringBuilder sb = new StringBuilder();
                            aVar6 = this.cIA.chosenData;
                            au aa = auVar.aa("tid", sb.append(aVar6.getThreadInfo().thread_id).toString());
                            aVar7 = this.cIA.chosenData;
                            au aa2 = aa.aa("obj_name", aVar7.getThreadInfo().tag_name);
                            aVar8 = this.cIA.chosenData;
                            au r = aa2.r("obj_source", aVar8.getThreadInfo().source.intValue());
                            aVar9 = this.cIA.chosenData;
                            TiebaStatic.log(r.aa("abtest", aVar9.getThreadInfo().abtest));
                        }
                    }
                    StringBuilder sb2 = new StringBuilder();
                    aVar4 = this.cIA.chosenData;
                    this.cIA.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(this.cIA.getPageContext().getPageActivity()).createSubPbActivityConfig(sb2.append(aVar4.getThreadInfo().thread_id).toString(), str, "pb_chosen", true, null, true)));
                }
            }
        }
    }
}
