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
class i implements View.OnClickListener {
    private final /* synthetic */ p ecq;
    final /* synthetic */ g ecw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar, p pVar) {
        this.ecw = gVar;
        this.ecq = pVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String forumName = this.ecq.getForumName();
        if (ay.aL(forumName)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.ecw.getActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_RECOMMEND)));
            TiebaStatic.log(new aw("c10509").ac("obj_name", this.ecq.dZX).ac("obj_source", this.ecq.eam).ac("abtest", this.ecq.abtest));
        }
    }
}
