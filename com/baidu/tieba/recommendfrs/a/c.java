package com.baidu.tieba.recommendfrs.a;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ b djC;
    private final /* synthetic */ com.baidu.tieba.recommendfrs.data.e djD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, com.baidu.tieba.recommendfrs.data.e eVar) {
        this.djC = bVar;
        this.djD = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String forumName = this.djD.getForumName();
        if (ax.aR(forumName)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.djC.getActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_RECOMMEND)));
            TiebaStatic.log(new av("c10509").ab("obj_name", this.djD.diR).ab("obj_source", this.djD.diS).ab("abtest", this.djD.abtest));
        }
    }
}
