package com.baidu.tieba.recommendfrs.a;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes.dex */
class k implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tieba.recommendfrs.data.b ctW;
    final /* synthetic */ j ctX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, com.baidu.tieba.recommendfrs.data.b bVar) {
        this.ctX = jVar;
        this.ctW = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String forumName = this.ctW.getForumName();
        if (aq.aP(forumName)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.ctX.getActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_RECOMMEND)));
        }
    }
}
