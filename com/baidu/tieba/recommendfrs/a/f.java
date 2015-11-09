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
class f implements View.OnClickListener {
    private final /* synthetic */ Hot_Thread cLh;
    final /* synthetic */ e cLi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, Hot_Thread hot_Thread) {
        this.cLi = eVar;
        this.cLh = hot_Thread;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str = this.cLh.forum_name;
        if (as.aN(str)) {
            TiebaStatic.eventStat(this.cLi.getActivity(), "kantie_6", null, 1, new Object[0]);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.cLi.getActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_RECOMMEND)));
        }
    }
}
