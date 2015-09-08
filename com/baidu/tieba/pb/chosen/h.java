package com.baidu.tieba.pb.chosen;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ PbChosenActivity bZS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PbChosenActivity pbChosenActivity) {
        this.bZS = pbChosenActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.pb.chosen.net.a aVar;
        com.baidu.tieba.pb.chosen.net.a aVar2;
        com.baidu.tieba.pb.chosen.net.a aVar3;
        aVar = this.bZS.chosenData;
        if (aVar != null) {
            aVar2 = this.bZS.chosenData;
            if (aVar2.getForumInfo() != null) {
                TiebaStatic.log("c10091");
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.bZS.getPageContext().getPageActivity());
                aVar3 = this.bZS.chosenData;
                this.bZS.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createNormalCfg(aVar3.getForumInfo().originalurl, null, null)));
            }
        }
    }
}
