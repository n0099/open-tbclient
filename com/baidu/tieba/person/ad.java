package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class ad implements View.OnClickListener {
    final /* synthetic */ t eeh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(t tVar) {
        this.eeh = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        af afVar;
        af afVar2;
        PersonBarActivity aKx;
        PersonBarActivity aKx2;
        int intValue = ((Integer) view.getTag()).intValue();
        if (intValue >= 0) {
            afVar = this.eeh.edR;
            if (intValue < afVar.getCount()) {
                afVar2 = this.eeh.edR;
                ForumData forumData = (ForumData) afVar2.getItem(intValue);
                aKx = this.eeh.aKx();
                if (aKx != null) {
                    aKx2 = this.eeh.aKx();
                    this.eeh.sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(aKx2.getPageContext().getPageActivity(), com.baidu.adp.lib.h.b.c(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                }
            }
        }
    }
}
