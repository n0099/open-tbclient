package com.baidu.tieba.recommendfrs.b;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.recommendfrs.data.l;
/* loaded from: classes.dex */
class i implements View.OnClickListener {
    private final /* synthetic */ l dGP;
    final /* synthetic */ g dGV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar, l lVar) {
        this.dGV = gVar;
        this.dGP = lVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String forumName = this.dGP.getForumName();
        if (aw.aQ(forumName)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.dGV.getActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_RECOMMEND)));
            TiebaStatic.log(new au("c10509").aa("obj_name", this.dGP.dFc).aa("obj_source", this.dGP.dFd).aa("abtest", this.dGP.abtest));
        }
    }
}
