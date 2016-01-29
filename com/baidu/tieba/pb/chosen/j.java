package com.baidu.tieba.pb.chosen;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ PbChosenActivity cIA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PbChosenActivity pbChosenActivity) {
        this.cIA = pbChosenActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.pb.chosen.net.a aVar;
        com.baidu.tieba.pb.chosen.net.a aVar2;
        com.baidu.tieba.pb.chosen.net.a aVar3;
        com.baidu.tieba.pb.chosen.net.a aVar4;
        com.baidu.tieba.pb.chosen.net.a aVar5;
        com.baidu.tieba.pb.chosen.net.a aVar6;
        com.baidu.tieba.pb.chosen.net.a aVar7;
        int i;
        aVar = this.cIA.chosenData;
        if (aVar != null) {
            aVar2 = this.cIA.chosenData;
            if (aVar2.getThreadInfo() != null) {
                au auVar = new au("c10091");
                StringBuilder sb = new StringBuilder();
                aVar3 = this.cIA.chosenData;
                au aa = auVar.aa("tid", sb.append(aVar3.getThreadInfo().thread_id).toString());
                aVar4 = this.cIA.chosenData;
                au aa2 = aa.aa("obj_name", aVar4.getThreadInfo().tag_name);
                aVar5 = this.cIA.chosenData;
                au r = aa2.r("obj_source", aVar5.getThreadInfo().source.intValue());
                aVar6 = this.cIA.chosenData;
                TiebaStatic.log(r.aa("abtest", aVar6.getThreadInfo().abtest));
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.cIA.getPageContext().getPageActivity());
                StringBuilder sb2 = new StringBuilder();
                aVar7 = this.cIA.chosenData;
                String sb3 = sb2.append(aVar7.getThreadInfo().thread_id).toString();
                i = this.cIA.cIq;
                this.cIA.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createCfgForPbChosen(sb3, i)));
            }
        }
    }
}
