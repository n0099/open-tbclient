package com.baidu.tieba.pb.chosen;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ PbChosenActivity bYY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PbChosenActivity pbChosenActivity) {
        this.bYY = pbChosenActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.pb.chosen.net.a aVar;
        com.baidu.tieba.pb.chosen.net.a aVar2;
        com.baidu.tieba.pb.chosen.net.a aVar3;
        aVar = this.bYY.chosenData;
        if (aVar != null) {
            aVar2 = this.bYY.chosenData;
            if (aVar2.getForumInfo() != null) {
                TiebaStatic.log("c10091");
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.bYY.getPageContext().getPageActivity());
                aVar3 = this.bYY.chosenData;
                this.bYY.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createNormalCfg(aVar3.getForumInfo().originalurl, null, null)));
            }
        }
    }
}
