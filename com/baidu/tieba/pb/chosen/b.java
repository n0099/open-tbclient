package com.baidu.tieba.pb.chosen;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.pb.chosen.a.e;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class b implements e.b {
    final /* synthetic */ PbChosenActivity cIA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(PbChosenActivity pbChosenActivity) {
        this.cIA = pbChosenActivity;
    }

    @Override // com.baidu.tieba.pb.chosen.a.e.b
    public void bb(String str, String str2) {
        this.cIA.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.cIA.getPageContext().getPageActivity(), str, str2)));
    }

    @Override // com.baidu.tieba.pb.chosen.a.e.b
    public void kt(String str) {
        com.baidu.tieba.pb.chosen.net.a aVar;
        com.baidu.tieba.pb.chosen.net.a aVar2;
        com.baidu.tieba.pb.chosen.net.a aVar3;
        com.baidu.tieba.pb.chosen.net.a aVar4;
        com.baidu.tieba.pb.chosen.net.a aVar5;
        if (!StringUtils.isNull(str)) {
            this.cIA.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.cIA.getPageContext().getPageActivity()).createNormalCfg(str, "from_chosen_pb")));
            aVar = this.cIA.chosenData;
            if (aVar != null) {
                aVar2 = this.cIA.chosenData;
                if (aVar2.getThreadInfo() != null) {
                    aVar3 = this.cIA.chosenData;
                    if (aVar3.getThreadInfo().excid != null) {
                        au auVar = new au("pb_new_sourcefid");
                        aVar4 = this.cIA.chosenData;
                        au r = auVar.r("obj_source", aVar4.getThreadInfo().source.intValue());
                        aVar5 = this.cIA.chosenData;
                        TiebaStatic.log(r.aa("abtest", aVar5.getThreadInfo().abtest));
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.pb.chosen.a.e.b
    public void aos() {
        com.baidu.tieba.pb.chosen.net.a aVar;
        com.baidu.tieba.pb.chosen.net.a aVar2;
        com.baidu.tieba.pb.chosen.net.a aVar3;
        com.baidu.tieba.tbadkCore.w wVar;
        com.baidu.tieba.tbadkCore.w wVar2;
        com.baidu.tieba.tbadkCore.w wVar3;
        com.baidu.tieba.tbadkCore.w wVar4;
        com.baidu.tieba.pb.chosen.net.a aVar4;
        com.baidu.tieba.pb.chosen.net.a aVar5;
        com.baidu.tieba.pb.chosen.net.a aVar6;
        com.baidu.tieba.pb.chosen.net.a aVar7;
        com.baidu.tieba.pb.chosen.net.a aVar8;
        com.baidu.tieba.pb.chosen.net.a aVar9;
        com.baidu.tieba.pb.chosen.net.a aVar10;
        com.baidu.tieba.pb.chosen.net.a aVar11;
        if (!com.baidu.adp.lib.util.i.iZ()) {
            BdToast.a(this.cIA.getPageContext().getPageActivity(), this.cIA.getResources().getString(t.j.neterror)).us();
        } else if (this.cIA.checkUpIsLogin()) {
            aVar = this.cIA.chosenData;
            if (aVar != null) {
                aVar2 = this.cIA.chosenData;
                if (aVar2.getThreadInfo() != null) {
                    aVar3 = this.cIA.chosenData;
                    if (aVar3.getThreadInfo().forum.forum_id != null) {
                        wVar = this.cIA.cIk;
                        if (wVar == null) {
                            this.cIA.cIk = new com.baidu.tieba.tbadkCore.w(this.cIA.getPageContext());
                        }
                        wVar2 = this.cIA.cIk;
                        wVar2.setFrom("from_frs");
                        wVar3 = this.cIA.cIk;
                        wVar3.setLoadDataCallBack(new c(this));
                        wVar4 = this.cIA.cIk;
                        aVar4 = this.cIA.chosenData;
                        String str = aVar4.getThreadInfo().forum.forum_name;
                        aVar5 = this.cIA.chosenData;
                        wVar4.bl(str, String.valueOf(aVar5.getThreadInfo().forum.forum_id));
                        aVar6 = this.cIA.chosenData;
                        if (aVar6 != null) {
                            aVar7 = this.cIA.chosenData;
                            if (aVar7.getThreadInfo() != null) {
                                au auVar = new au("c10322");
                                StringBuilder sb = new StringBuilder();
                                aVar8 = this.cIA.chosenData;
                                au aa = auVar.aa(ImageViewerConfig.FORUM_ID, sb.append(aVar8.getThreadInfo().forum.forum_id).toString());
                                StringBuilder sb2 = new StringBuilder();
                                aVar9 = this.cIA.chosenData;
                                au aa2 = aa.aa("tid", sb2.append(aVar9.getThreadInfo().thread_id).toString());
                                aVar10 = this.cIA.chosenData;
                                au r = aa2.r("obj_source", aVar10.getThreadInfo().source.intValue());
                                aVar11 = this.cIA.chosenData;
                                TiebaStatic.log(r.aa("abtest", aVar11.getThreadInfo().abtest));
                            }
                        }
                    }
                }
            }
        }
    }
}
