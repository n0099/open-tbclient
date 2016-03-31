package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class aa implements View.OnClickListener {
    final /* synthetic */ s dst;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(s sVar) {
        this.dst = sVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ad adVar;
        ad adVar2;
        PersonBarActivity aBf;
        PersonBarActivity aBf2;
        int intValue = ((Integer) view.getTag()).intValue();
        if (intValue >= 0) {
            adVar = this.dst.dsd;
            if (intValue < adVar.getCount()) {
                adVar2 = this.dst.dsd;
                ForumData forumData = (ForumData) adVar2.getItem(intValue);
                aBf = this.dst.aBf();
                if (aBf != null) {
                    aBf2 = this.dst.aBf();
                    this.dst.sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(aBf2.getPageContext().getPageActivity(), com.baidu.adp.lib.h.b.c(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                }
            }
        }
    }
}
