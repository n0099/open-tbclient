package com.baidu.tieba.recommendfrs.a;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import tbclient.FineFrsPage.Hot_Thread;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    final /* synthetic */ c cJl;
    private final /* synthetic */ Hot_Thread cJm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, Hot_Thread hot_Thread) {
        this.cJl = cVar;
        this.cJm = hot_Thread;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str = this.cJm.forum_name;
        if (ar.aP(str)) {
            TiebaStatic.eventStat(this.cJl.getActivity(), "kantie_6", null, 1, new Object[0]);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.cJl.getActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_RECOMMEND)));
        }
    }
}
