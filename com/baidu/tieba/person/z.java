package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class z implements View.OnClickListener {
    final /* synthetic */ r cpq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(r rVar) {
        this.cpq = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ac acVar;
        ac acVar2;
        PersonBarActivity aio;
        PersonBarActivity aio2;
        int intValue = ((Integer) view.getTag()).intValue();
        if (intValue >= 0) {
            acVar = this.cpq.cpa;
            if (intValue < acVar.getCount()) {
                acVar2 = this.cpq.cpa;
                ForumData forumData = (ForumData) acVar2.getItem(intValue);
                aio = this.cpq.aio();
                if (aio != null) {
                    aio2 = this.cpq.aio();
                    this.cpq.sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(aio2.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                }
            }
        }
    }
}
