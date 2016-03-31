package com.baidu.tieba.recommendfrs.view;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.recommendfrs.data.p;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ c dZi;
    private final /* synthetic */ p dZj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar, p pVar) {
        this.dZi = cVar;
        this.dZj = pVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String forumName = this.dZj.getForumName();
        if (ay.aS(forumName)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.dZi.getActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_RECOMMEND)));
            TiebaStatic.log(new aw("c10509").ac("obj_name", this.dZj.dWN).ac("obj_source", this.dZj.dXd).ac("abtest", this.dZj.abtest));
        }
    }
}
