package com.baidu.tieba.recommendfrs.a;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.recommendfrs.data.j;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    private final /* synthetic */ j dqL;
    final /* synthetic */ e dqR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, j jVar) {
        this.dqR = eVar;
        this.dqL = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String forumName = this.dqL.getForumName();
        if (ax.aR(forumName)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.dqR.getActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_RECOMMEND)));
            TiebaStatic.log(new av("c10509").aa("obj_name", this.dqL.dpt).aa("obj_source", this.dqL.dpu).aa("abtest", this.dqL.abtest));
        }
    }
}
