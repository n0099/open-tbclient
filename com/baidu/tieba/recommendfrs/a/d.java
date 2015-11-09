package com.baidu.tieba.recommendfrs.a;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import tbclient.FineFrsPage.Hot_Thread;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    final /* synthetic */ c cLg;
    private final /* synthetic */ Hot_Thread cLh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, Hot_Thread hot_Thread) {
        this.cLg = cVar;
        this.cLh = hot_Thread;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str = this.cLh.forum_name;
        if (as.aN(str)) {
            TiebaStatic.eventStat(this.cLg.getActivity(), "kantie_6", null, 1, new Object[0]);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.cLg.getActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_RECOMMEND)));
        }
    }
}
