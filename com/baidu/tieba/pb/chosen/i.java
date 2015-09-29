package com.baidu.tieba.pb.chosen;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ PbChosenActivity cfa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(PbChosenActivity pbChosenActivity) {
        this.cfa = pbChosenActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.pb.chosen.net.a aVar;
        com.baidu.tieba.pb.chosen.net.a aVar2;
        com.baidu.tieba.pb.chosen.net.a aVar3;
        aVar = this.cfa.chosenData;
        if (aVar != null) {
            aVar2 = this.cfa.chosenData;
            if (aVar2.getForumInfo() != null) {
                TiebaStatic.log("c10091");
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.cfa.getPageContext().getPageActivity());
                aVar3 = this.cfa.chosenData;
                this.cfa.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createNormalCfg(aVar3.getForumInfo().originalurl, null, null)));
            }
        }
    }
}
