package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class aa implements View.OnClickListener {
    final /* synthetic */ s cXR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(s sVar) {
        this.cXR = sVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ad adVar;
        ad adVar2;
        PersonBarActivity atz;
        PersonBarActivity atz2;
        int intValue = ((Integer) view.getTag()).intValue();
        if (intValue >= 0) {
            adVar = this.cXR.cXB;
            if (intValue < adVar.getCount()) {
                adVar2 = this.cXR.cXB;
                ForumData forumData = (ForumData) adVar2.getItem(intValue);
                atz = this.cXR.atz();
                if (atz != null) {
                    atz2 = this.cXR.atz();
                    this.cXR.sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(atz2.getPageContext().getPageActivity(), com.baidu.adp.lib.h.b.c(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                }
            }
        }
    }
}
