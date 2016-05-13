package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class ac implements View.OnClickListener {
    final /* synthetic */ s dvP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(s sVar) {
        this.dvP = sVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ae aeVar;
        ae aeVar2;
        PersonBarActivity aBF;
        PersonBarActivity aBF2;
        int intValue = ((Integer) view.getTag()).intValue();
        if (intValue >= 0) {
            aeVar = this.dvP.dvz;
            if (intValue < aeVar.getCount()) {
                aeVar2 = this.dvP.dvz;
                ForumData forumData = (ForumData) aeVar2.getItem(intValue);
                aBF = this.dvP.aBF();
                if (aBF != null) {
                    aBF2 = this.dvP.aBF();
                    this.dvP.sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(aBF2.getPageContext().getPageActivity(), com.baidu.adp.lib.h.b.c(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                }
            }
        }
    }
}
