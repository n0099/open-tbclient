package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class aa implements View.OnClickListener {
    final /* synthetic */ s cKg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(s sVar) {
        this.cKg = sVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ad adVar;
        ad adVar2;
        PersonBarActivity anx;
        PersonBarActivity anx2;
        int intValue = ((Integer) view.getTag()).intValue();
        if (intValue >= 0) {
            adVar = this.cKg.cJR;
            if (intValue < adVar.getCount()) {
                adVar2 = this.cKg.cJR;
                ForumData forumData = (ForumData) adVar2.getItem(intValue);
                anx = this.cKg.anx();
                if (anx != null) {
                    anx2 = this.cKg.anx();
                    this.cKg.sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(anx2.getPageContext().getPageActivity(), com.baidu.adp.lib.h.b.c(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                }
            }
        }
    }
}
