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
    final /* synthetic */ PbChosenActivity cyo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(PbChosenActivity pbChosenActivity) {
        this.cyo = pbChosenActivity;
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
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.cyo.getPageContext().getPageActivity());
            i = this.cyo.cyd;
            this.cyo.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createCfgForPbChosen(str, i)));
            aVar = this.cyo.chosenData;
            if (aVar != null) {
                aVar2 = this.cyo.chosenData;
                if (aVar2.getThreadInfo() != null) {
                    aVar3 = this.cyo.chosenData;
                    if (aVar3.getThreadInfo().excid != null) {
                        av avVar = new av("pb_new_detail_btn");
                        aVar4 = this.cyo.chosenData;
                        av r = avVar.r("obj_source", aVar4.getThreadInfo().source.intValue());
                        aVar5 = this.cyo.chosenData;
                        TiebaStatic.log(r.ab("abtest", aVar5.getThreadInfo().abtest));
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.pb.chosen.a.i.a
    public void eN(boolean z) {
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
        aVar = this.cyo.chosenData;
        if (aVar != null) {
            aVar2 = this.cyo.chosenData;
            if (aVar2.getThreadInfo() != null) {
                aVar3 = this.cyo.chosenData;
                if (aVar3.getThreadInfo().excid != null) {
                    aVar4 = this.cyo.cxY;
                    if (aVar4 == null) {
                        this.cyo.cxY = new com.baidu.tieba.pb.chosen.net.zan.a();
                    }
                    if (z) {
                        aVar11 = this.cyo.cxY;
                        PbChosenActivity pbChosenActivity = this.cyo;
                        aVar12 = this.cyo.chosenData;
                        long longValue = aVar12.getThreadInfo().excid.longValue();
                        aVar13 = this.cyo.chosenData;
                        long longValue2 = aVar13.getThreadInfo().thread_id.longValue();
                        aVar14 = this.cyo.chosenData;
                        aVar11.a(pbChosenActivity, longValue, longValue2, aVar14.getThreadInfo().post_id.longValue(), 2);
                    } else {
                        aVar5 = this.cyo.cxY;
                        PbChosenActivity pbChosenActivity2 = this.cyo;
                        aVar6 = this.cyo.chosenData;
                        long longValue3 = aVar6.getThreadInfo().excid.longValue();
                        aVar7 = this.cyo.chosenData;
                        long longValue4 = aVar7.getThreadInfo().thread_id.longValue();
                        aVar8 = this.cyo.chosenData;
                        aVar5.a(pbChosenActivity2, longValue3, longValue4, aVar8.getThreadInfo().post_id.longValue(), 1);
                    }
                    av avVar = new av("pb_new_like");
                    aVar9 = this.cyo.chosenData;
                    av r = avVar.r("obj_source", aVar9.getThreadInfo().source.intValue());
                    aVar10 = this.cyo.chosenData;
                    TiebaStatic.log(r.ab("abtest", aVar10.getThreadInfo().abtest));
                }
            }
        }
    }
}
