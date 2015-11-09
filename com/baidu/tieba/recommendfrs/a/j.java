package com.baidu.tieba.recommendfrs.a;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.as;
/* loaded from: classes.dex */
class j implements View.OnClickListener {
    final /* synthetic */ i cLn;
    private final /* synthetic */ com.baidu.tieba.recommendfrs.data.b cLo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, com.baidu.tieba.recommendfrs.data.b bVar) {
        this.cLn = iVar;
        this.cLo = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String forumName = this.cLo.getForumName();
        if (as.aN(forumName)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.cLn.getActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_RECOMMEND)));
        }
    }
}
