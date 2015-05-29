package com.baidu.tieba.person;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
/* loaded from: classes.dex */
class ad implements View.OnClickListener {
    final /* synthetic */ v bSb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(v vVar) {
        this.bSb = vVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ag agVar;
        ag agVar2;
        PersonBarActivity ael;
        PersonBarActivity ael2;
        int intValue = ((Integer) view.getTag()).intValue();
        if (intValue >= 0) {
            agVar = this.bSb.bRM;
            if (intValue < agVar.getCount()) {
                agVar2 = this.bSb.bRM;
                ForumData forumData = (ForumData) agVar2.getItem(intValue);
                ael = this.bSb.ael();
                if (ael != null) {
                    ael2 = this.bSb.ael();
                    this.bSb.sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(ael2.getPageContext().getPageActivity(), com.baidu.adp.lib.g.c.c(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                }
            }
        }
    }
}
