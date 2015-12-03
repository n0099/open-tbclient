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
    final /* synthetic */ PbChosenActivity cyo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(PbChosenActivity pbChosenActivity) {
        this.cyo = pbChosenActivity;
    }

    @Override // com.baidu.tieba.pb.chosen.a.e.b
    public void aZ(String str, String str2) {
        this.cyo.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.cyo.getPageContext().getPageActivity(), str, str2)));
    }

    @Override // com.baidu.tieba.pb.chosen.a.e.b
    public void kt(String str) {
        com.baidu.tieba.pb.chosen.net.a aVar;
        com.baidu.tieba.pb.chosen.net.a aVar2;
        com.baidu.tieba.pb.chosen.net.a aVar3;
        com.baidu.tieba.pb.chosen.net.a aVar4;
        com.baidu.tieba.pb.chosen.net.a aVar5;
        if (!StringUtils.isNull(str)) {
            this.cyo.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.cyo.getPageContext().getPageActivity()).createNormalCfg(str, "from_chosen_pb")));
            aVar = this.cyo.chosenData;
            if (aVar != null) {
                aVar2 = this.cyo.chosenData;
                if (aVar2.getThreadInfo() != null) {
                    aVar3 = this.cyo.chosenData;
                    if (aVar3.getThreadInfo().excid != null) {
                        av avVar = new av("pb_new_sourcefid");
                        aVar4 = this.cyo.chosenData;
                        av r = avVar.r("obj_source", aVar4.getThreadInfo().source.intValue());
                        aVar5 = this.cyo.chosenData;
                        TiebaStatic.log(r.ab("abtest", aVar5.getThreadInfo().abtest));
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.pb.chosen.a.e.b
    public void ajn() {
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
        if (!com.baidu.adp.lib.util.i.iP()) {
            BdToast.b(this.cyo.getPageContext().getPageActivity(), this.cyo.getResources().getString(n.i.neterror)).tE();
        } else if (this.cyo.checkUpIsLogin()) {
            aVar = this.cyo.chosenData;
            if (aVar != null) {
                aVar2 = this.cyo.chosenData;
                if (aVar2.getThreadInfo() != null) {
                    aVar3 = this.cyo.chosenData;
                    if (aVar3.getThreadInfo().forum.forum_id != null) {
                        xVar = this.cyo.cxX;
                        if (xVar == null) {
                            this.cyo.cxX = new com.baidu.tieba.tbadkCore.x(this.cyo.getPageContext());
                        }
                        xVar2 = this.cyo.cxX;
                        xVar2.setFrom("from_frs");
                        xVar3 = this.cyo.cxX;
                        xVar3.setLoadDataCallBack(new c(this));
                        xVar4 = this.cyo.cxX;
                        aVar4 = this.cyo.chosenData;
                        String str = aVar4.getThreadInfo().forum.forum_name;
                        aVar5 = this.cyo.chosenData;
                        xVar4.bg(str, String.valueOf(aVar5.getThreadInfo().forum.forum_id));
                        aVar6 = this.cyo.chosenData;
                        if (aVar6 != null) {
                            aVar7 = this.cyo.chosenData;
                            if (aVar7.getThreadInfo() != null) {
                                av avVar = new av("c10322");
                                StringBuilder sb = new StringBuilder();
                                aVar8 = this.cyo.chosenData;
                                av ab = avVar.ab(ImageViewerConfig.FORUM_ID, sb.append(aVar8.getThreadInfo().forum.forum_id).toString());
                                StringBuilder sb2 = new StringBuilder();
                                aVar9 = this.cyo.chosenData;
                                av ab2 = ab.ab("tid", sb2.append(aVar9.getThreadInfo().thread_id).toString());
                                aVar10 = this.cyo.chosenData;
                                av r = ab2.r("obj_source", aVar10.getThreadInfo().source.intValue());
                                aVar11 = this.cyo.chosenData;
                                TiebaStatic.log(r.ab("abtest", aVar11.getThreadInfo().abtest));
                            }
                        }
                    }
                }
            }
        }
    }
}
