package com.baidu.tieba.recommendfrs.a;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bb;
import tbclient.FineFrsPage.Hot_Thread;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ b cct;
    private final /* synthetic */ Hot_Thread ccu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, Hot_Thread hot_Thread) {
        this.cct = bVar;
        this.ccu = hot_Thread;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str = this.ccu.forum_name;
        if (bb.aT(str)) {
            TiebaStatic.eventStat(this.cct.getActivity(), "kantie_6", null, 1, new Object[0]);
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.cct.getActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_RECOMMEND)));
        }
    }
}
