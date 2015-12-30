package com.baidu.tieba.pb.chosen;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.n;
import com.baidu.tieba.pb.chosen.a.e;
/* loaded from: classes.dex */
class b implements e.b {
    final /* synthetic */ PbChosenActivity cBV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(PbChosenActivity pbChosenActivity) {
        this.cBV = pbChosenActivity;
    }

    @Override // com.baidu.tieba.pb.chosen.a.e.b
    public void aU(String str, String str2) {
        this.cBV.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.cBV.getPageContext().getPageActivity(), str, str2)));
    }

    @Override // com.baidu.tieba.pb.chosen.a.e.b
    public void kp(String str) {
        com.baidu.tieba.pb.chosen.net.a aVar;
        com.baidu.tieba.pb.chosen.net.a aVar2;
        com.baidu.tieba.pb.chosen.net.a aVar3;
        com.baidu.tieba.pb.chosen.net.a aVar4;
        com.baidu.tieba.pb.chosen.net.a aVar5;
        if (!StringUtils.isNull(str)) {
            this.cBV.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.cBV.getPageContext().getPageActivity()).createNormalCfg(str, "from_chosen_pb")));
            aVar = this.cBV.chosenData;
            if (aVar != null) {
                aVar2 = this.cBV.chosenData;
                if (aVar2.getThreadInfo() != null) {
                    aVar3 = this.cBV.chosenData;
                    if (aVar3.getThreadInfo().excid != null) {
                        av avVar = new av("pb_new_sourcefid");
                        aVar4 = this.cBV.chosenData;
                        av r = avVar.r("obj_source", aVar4.getThreadInfo().source.intValue());
                        aVar5 = this.cBV.chosenData;
                        TiebaStatic.log(r.aa("abtest", aVar5.getThreadInfo().abtest));
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.pb.chosen.a.e.b
    public void aku() {
        com.baidu.tieba.pb.chosen.net.a aVar;
        com.baidu.tieba.pb.chosen.net.a aVar2;
        com.baidu.tieba.pb.chosen.net.a aVar3;
        com.baidu.tieba.tbadkCore.x xVar;
        com.baidu.tieba.tbadkCore.x xVar2;
        com.baidu.tieba.tbadkCore.x xVar3;
        com.baidu.tieba.tbadkCore.x xVar4;
        com.baidu.tieba.pb.chosen.net.a aVar4;
        com.baidu.tieba.pb.chosen.net.a aVar5;
        com.baidu.tieba.pb.chosen.net.a aVar6;
        com.baidu.tieba.pb.chosen.net.a aVar7;
        com.baidu.tieba.pb.chosen.net.a aVar8;
        com.baidu.tieba.pb.chosen.net.a aVar9;
        com.baidu.tieba.pb.chosen.net.a aVar10;
        com.baidu.tieba.pb.chosen.net.a aVar11;
        if (!com.baidu.adp.lib.util.i.iQ()) {
            BdToast.b(this.cBV.getPageContext().getPageActivity(), this.cBV.getResources().getString(n.j.neterror)).to();
        } else if (this.cBV.checkUpIsLogin()) {
            aVar = this.cBV.chosenData;
            if (aVar != null) {
                aVar2 = this.cBV.chosenData;
                if (aVar2.getThreadInfo() != null) {
                    aVar3 = this.cBV.chosenData;
                    if (aVar3.getThreadInfo().forum.forum_id != null) {
                        xVar = this.cBV.cBE;
                        if (xVar == null) {
                            this.cBV.cBE = new com.baidu.tieba.tbadkCore.x(this.cBV.getPageContext());
                        }
                        xVar2 = this.cBV.cBE;
                        xVar2.setFrom("from_frs");
                        xVar3 = this.cBV.cBE;
                        xVar3.setLoadDataCallBack(new c(this));
                        xVar4 = this.cBV.cBE;
                        aVar4 = this.cBV.chosenData;
                        String str = aVar4.getThreadInfo().forum.forum_name;
                        aVar5 = this.cBV.chosenData;
                        xVar4.bc(str, String.valueOf(aVar5.getThreadInfo().forum.forum_id));
                        aVar6 = this.cBV.chosenData;
                        if (aVar6 != null) {
                            aVar7 = this.cBV.chosenData;
                            if (aVar7.getThreadInfo() != null) {
                                av avVar = new av("c10322");
                                StringBuilder sb = new StringBuilder();
                                aVar8 = this.cBV.chosenData;
                                av aa = avVar.aa(ImageViewerConfig.FORUM_ID, sb.append(aVar8.getThreadInfo().forum.forum_id).toString());
                                StringBuilder sb2 = new StringBuilder();
                                aVar9 = this.cBV.chosenData;
                                av aa2 = aa.aa("tid", sb2.append(aVar9.getThreadInfo().thread_id).toString());
                                aVar10 = this.cBV.chosenData;
                                av r = aa2.r("obj_source", aVar10.getThreadInfo().source.intValue());
                                aVar11 = this.cBV.chosenData;
                                TiebaStatic.log(r.aa("abtest", aVar11.getThreadInfo().abtest));
                            }
                        }
                    }
                }
            }
        }
    }
}
