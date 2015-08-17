package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class z implements View.OnClickListener {
    final /* synthetic */ r ciI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(r rVar) {
        this.ciI = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ac acVar;
        ac acVar2;
        PersonBarActivity agd;
        PersonBarActivity agd2;
        int intValue = ((Integer) view.getTag()).intValue();
        if (intValue >= 0) {
            acVar = this.ciI.cis;
            if (intValue < acVar.getCount()) {
                acVar2 = this.ciI.cis;
                ForumData forumData = (ForumData) acVar2.getItem(intValue);
                agd = this.ciI.agd();
                if (agd != null) {
                    agd2 = this.ciI.agd();
                    this.ciI.sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(agd2.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                }
            }
        }
    }
}
