package com.baidu.tieba.recommendfrs.a;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ar;
/* loaded from: classes.dex */
class l implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tieba.recommendfrs.data.b cJt;
    final /* synthetic */ k cJu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar, com.baidu.tieba.recommendfrs.data.b bVar) {
        this.cJu = kVar;
        this.cJt = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String forumName = this.cJt.getForumName();
        if (ar.aP(forumName)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.cJu.getActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_RECOMMEND)));
        }
    }
}
