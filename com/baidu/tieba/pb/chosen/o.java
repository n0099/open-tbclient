package com.baidu.tieba.pb.chosen;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.pb.chosen.a.d;
/* loaded from: classes.dex */
class o implements d.a {
    final /* synthetic */ PbChosenActivity cBV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(PbChosenActivity pbChosenActivity) {
        this.cBV = pbChosenActivity;
    }

    @Override // com.baidu.tieba.pb.chosen.a.d.a
    public void kr(String str) {
        com.baidu.tieba.pb.chosen.net.a aVar;
        com.baidu.tieba.pb.chosen.net.a aVar2;
        com.baidu.tieba.pb.chosen.net.a aVar3;
        com.baidu.tieba.pb.chosen.net.a aVar4;
        com.baidu.tieba.pb.chosen.net.a aVar5;
        com.baidu.tieba.pb.chosen.net.a aVar6;
        com.baidu.tieba.pb.chosen.net.a aVar7;
        com.baidu.tieba.pb.chosen.net.a aVar8;
        com.baidu.tieba.pb.chosen.net.a aVar9;
        if (this.cBV.checkUpIsLogin()) {
            aVar = this.cBV.chosenData;
            if (aVar != null) {
                aVar2 = this.cBV.chosenData;
                if (aVar2.getThreadInfo() != null && !StringUtils.isNull(str)) {
                    aVar3 = this.cBV.chosenData;
                    if (aVar3 != null) {
                        aVar5 = this.cBV.chosenData;
                        if (aVar5.getThreadInfo() != null) {
                            av avVar = new av("c10093");
                            StringBuilder sb = new StringBuilder();
                            aVar6 = this.cBV.chosenData;
                            av aa = avVar.aa("tid", sb.append(aVar6.getThreadInfo().thread_id).toString());
                            aVar7 = this.cBV.chosenData;
                            av aa2 = aa.aa("obj_name", aVar7.getThreadInfo().tag_name);
                            aVar8 = this.cBV.chosenData;
                            av r = aa2.r("obj_source", aVar8.getThreadInfo().source.intValue());
                            aVar9 = this.cBV.chosenData;
                            TiebaStatic.log(r.aa("abtest", aVar9.getThreadInfo().abtest));
                        }
                    }
                    StringBuilder sb2 = new StringBuilder();
                    aVar4 = this.cBV.chosenData;
                    this.cBV.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(this.cBV.getPageContext().getPageActivity()).createSubPbActivityConfig(sb2.append(aVar4.getThreadInfo().thread_id).toString(), str, "pb_chosen", true, null, true)));
                }
            }
        }
    }
}
