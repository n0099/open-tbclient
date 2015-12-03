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
    final /* synthetic */ PbChosenActivity cyo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(PbChosenActivity pbChosenActivity) {
        this.cyo = pbChosenActivity;
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
        if (this.cyo.checkUpIsLogin()) {
            aVar = this.cyo.chosenData;
            if (aVar != null) {
                aVar2 = this.cyo.chosenData;
                if (aVar2.getThreadInfo() != null && !StringUtils.isNull(str)) {
                    aVar3 = this.cyo.chosenData;
                    if (aVar3 != null) {
                        aVar5 = this.cyo.chosenData;
                        if (aVar5.getThreadInfo() != null) {
                            av avVar = new av("c10093");
                            StringBuilder sb = new StringBuilder();
                            aVar6 = this.cyo.chosenData;
                            av ab = avVar.ab("tid", sb.append(aVar6.getThreadInfo().thread_id).toString());
                            aVar7 = this.cyo.chosenData;
                            av ab2 = ab.ab("obj_name", aVar7.getThreadInfo().tag_name);
                            aVar8 = this.cyo.chosenData;
                            av r = ab2.r("obj_source", aVar8.getThreadInfo().source.intValue());
                            aVar9 = this.cyo.chosenData;
                            TiebaStatic.log(r.ab("abtest", aVar9.getThreadInfo().abtest));
                        }
                    }
                    StringBuilder sb2 = new StringBuilder();
                    aVar4 = this.cyo.chosenData;
                    this.cyo.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(this.cyo.getPageContext().getPageActivity()).createSubPbActivityConfig(sb2.append(aVar4.getThreadInfo().thread_id).toString(), str, "pb_chosen", true, null, true)));
                }
            }
        }
    }
}
