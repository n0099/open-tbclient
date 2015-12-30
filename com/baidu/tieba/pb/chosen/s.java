package com.baidu.tieba.pb.chosen;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.pb.chosen.a.i;
/* loaded from: classes.dex */
class s implements i.a {
    final /* synthetic */ PbChosenActivity cBV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(PbChosenActivity pbChosenActivity) {
        this.cBV = pbChosenActivity;
    }

    @Override // com.baidu.tieba.pb.chosen.a.i.a
    public void g(long j, String str) {
        int i;
        com.baidu.tieba.pb.chosen.net.a aVar;
        com.baidu.tieba.pb.chosen.net.a aVar2;
        com.baidu.tieba.pb.chosen.net.a aVar3;
        com.baidu.tieba.pb.chosen.net.a aVar4;
        com.baidu.tieba.pb.chosen.net.a aVar5;
        if (!StringUtils.isNull(str)) {
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.cBV.getPageContext().getPageActivity());
            i = this.cBV.cBK;
            this.cBV.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createCfgForPbChosen(str, i)));
            aVar = this.cBV.chosenData;
            if (aVar != null) {
                aVar2 = this.cBV.chosenData;
                if (aVar2.getThreadInfo() != null) {
                    aVar3 = this.cBV.chosenData;
                    if (aVar3.getThreadInfo().excid != null) {
                        av avVar = new av("pb_new_detail_btn");
                        aVar4 = this.cBV.chosenData;
                        av r = avVar.r("obj_source", aVar4.getThreadInfo().source.intValue());
                        aVar5 = this.cBV.chosenData;
                        TiebaStatic.log(r.aa("abtest", aVar5.getThreadInfo().abtest));
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.pb.chosen.a.i.a
    public void eM(boolean z) {
        com.baidu.tieba.pb.chosen.net.a aVar;
        com.baidu.tieba.pb.chosen.net.a aVar2;
        com.baidu.tieba.pb.chosen.net.a aVar3;
        com.baidu.tieba.pb.chosen.net.zan.a aVar4;
        com.baidu.tieba.pb.chosen.net.zan.a aVar5;
        com.baidu.tieba.pb.chosen.net.a aVar6;
        com.baidu.tieba.pb.chosen.net.a aVar7;
        com.baidu.tieba.pb.chosen.net.a aVar8;
        com.baidu.tieba.pb.chosen.net.a aVar9;
        com.baidu.tieba.pb.chosen.net.a aVar10;
        com.baidu.tieba.pb.chosen.net.zan.a aVar11;
        com.baidu.tieba.pb.chosen.net.a aVar12;
        com.baidu.tieba.pb.chosen.net.a aVar13;
        com.baidu.tieba.pb.chosen.net.a aVar14;
        aVar = this.cBV.chosenData;
        if (aVar != null) {
            aVar2 = this.cBV.chosenData;
            if (aVar2.getThreadInfo() != null) {
                aVar3 = this.cBV.chosenData;
                if (aVar3.getThreadInfo().excid != null) {
                    aVar4 = this.cBV.cBF;
                    if (aVar4 == null) {
                        this.cBV.cBF = new com.baidu.tieba.pb.chosen.net.zan.a();
                    }
                    if (z) {
                        aVar11 = this.cBV.cBF;
                        PbChosenActivity pbChosenActivity = this.cBV;
                        aVar12 = this.cBV.chosenData;
                        long longValue = aVar12.getThreadInfo().excid.longValue();
                        aVar13 = this.cBV.chosenData;
                        long longValue2 = aVar13.getThreadInfo().thread_id.longValue();
                        aVar14 = this.cBV.chosenData;
                        aVar11.a(pbChosenActivity, longValue, longValue2, aVar14.getThreadInfo().post_id.longValue(), 2);
                    } else {
                        aVar5 = this.cBV.cBF;
                        PbChosenActivity pbChosenActivity2 = this.cBV;
                        aVar6 = this.cBV.chosenData;
                        long longValue3 = aVar6.getThreadInfo().excid.longValue();
                        aVar7 = this.cBV.chosenData;
                        long longValue4 = aVar7.getThreadInfo().thread_id.longValue();
                        aVar8 = this.cBV.chosenData;
                        aVar5.a(pbChosenActivity2, longValue3, longValue4, aVar8.getThreadInfo().post_id.longValue(), 1);
                    }
                    av avVar = new av("pb_new_like");
                    aVar9 = this.cBV.chosenData;
                    av r = avVar.r("obj_source", aVar9.getThreadInfo().source.intValue());
                    aVar10 = this.cBV.chosenData;
                    TiebaStatic.log(r.aa("abtest", aVar10.getThreadInfo().abtest));
                }
            }
        }
    }
}
