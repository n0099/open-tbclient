package com.baidu.tieba.recommendfrs.a;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import tbclient.FineFrsPage.Hot_Thread;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    private final /* synthetic */ Hot_Thread ctT;
    final /* synthetic */ e ctU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, Hot_Thread hot_Thread) {
        this.ctU = eVar;
        this.ctT = hot_Thread;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str = this.ctT.forum_name;
        if (aq.aP(str)) {
            TiebaStatic.eventStat(this.ctU.getActivity(), "kantie_6", null, 1, new Object[0]);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.ctU.getActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_RECOMMEND)));
        }
    }
}
